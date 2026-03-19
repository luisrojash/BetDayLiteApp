package com.prueba.tecnica.core.domain

sealed class Failure {
    data class BadRequest(val code : String,val message: String, val any: Any? = null) : Failure()
    data class AuthorizationRequired(val code : String,val message: String, val any: Any? = null) : Failure()
    data class AccessDeniedOrForbidden(val code : String, val message: String, val any: Any? = null) : Failure()
    data class NotFound(val code : String,val message: String, val any: Any? = null) : Failure()
    data class Conflict(val code : String,val message: String, val any: Any? = null) : Failure()
    data class Limits(val code : String, val message: String, val any: Any? = null) : Failure()
    data class DestinationLocked(val code : String,val message: String, val any: Any? = null) : Failure()
    data class Unprocessable(val code : String,val message: String, val any: Any? = null) : Failure()
    data class Locked(val code : String,val message: String, val any: Any? = null) : Failure()
    data class TooManyRequest(val code : String,val message: String, val any: Any? = null) : Failure()
    data class Internal(val code : String,val message: String, val any: Any? = null) : Failure()
    data class ServiceUnavailable(val code : String,val message: String, val any: Any? = null) : Failure()
    data class PreconditionFailed(val code : String,val message: String, val any: Any? = null) : Failure()
    data class OtpRequired(val code : String,val message: String, val any: Any? = null,val subErrors: List<Any>?) : Failure()
    object NetworkLost : Failure()
    object Others : Failure()
}

fun findFailure(httpCode: Int, message: String,code: String,subErrors: List<Any>?): Failure {
    return when (httpCode) {
        400 -> Failure.BadRequest(message = message,code = code)
        401 -> Failure.AuthorizationRequired(message = message,code = code)
        403 -> Failure.AccessDeniedOrForbidden(message = message,code = code)
        404 -> Failure.NotFound(message = message,code = code)
        409 -> Failure.Conflict(message = message,code = code)
        412 -> Failure.PreconditionFailed(message = message,code = code)
        421 -> Failure.DestinationLocked(message = message,code = code)
        422 -> Failure.Unprocessable(message = message,code = code)
        423 -> Failure.Locked(message = message,code = code)
        428 -> Failure.Limits(message = message,code = code ,any=subErrors)
        429 -> Failure.TooManyRequest(message = message,code = code)
        500 -> Failure.Internal(message = message,code = code)
        503 -> Failure.ServiceUnavailable(message = message,code = code)
        else -> Failure.Others
    }
}