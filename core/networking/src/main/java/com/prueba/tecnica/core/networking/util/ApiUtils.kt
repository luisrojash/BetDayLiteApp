package com.prueba.tecnica.core.networking.util



import com.google.gson.Gson
import com.prueba.tecnica.core.networking.remote.ErrorResponse
import com.prueba.tecnica.core.domain.Failure
import com.prueba.tecnica.core.domain.Result
import com.prueba.tecnica.core.domain.findFailure

import retrofit2.Response
import java.io.IOException

suspend fun <R> executeApiService(
    api: suspend () -> Response<R>
): Result<R> {
    return executeApiService(api = api, transformInfrastructureToDomain = {it})
}

fun <R, D> transform(response: Response<R>): Result<D> {
    val httpCode: Int = response.code()
    return try {
        val errorResponse: ErrorResponse =
            Gson().fromJson(response.errorBody()!!.charStream(), ErrorResponse::class.java)
        Result.Error(findFailure(httpCode,errorResponse.message.orEmpty(), code = errorResponse.code.orEmpty(),errorResponse.subErrors))
    } catch (t: Throwable){
        handleThrowable(t)
    }
}

suspend fun <D, R> executeApiService(
    transformInfrastructureToDomain: (R) -> D,
    api: suspend () -> Response<R>
): Result<D> {
    try {
        val response: Response<R> = api()
        if (response.isSuccessful) {
            val data = response.body()!!
            val domainResponse = transformInfrastructureToDomain.invoke(data)
            return Result.Success(domainResponse)
        }
        return transform(response)
    } catch (t: Throwable) {
        return handleThrowable(t)
    }
}

fun <D> handleThrowable(t: Throwable): Result<D> = Result.Error(
    when (t) {
        is IOException -> Failure.NetworkLost
        else -> Failure.Others
    }
)