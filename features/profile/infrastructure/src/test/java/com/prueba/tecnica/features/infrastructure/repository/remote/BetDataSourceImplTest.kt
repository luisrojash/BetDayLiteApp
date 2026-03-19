package com.prueba.tecnica.features.infrastructure.repository.remote

import com.prueba.tecnica.core.domain.Result
import com.prueba.tecnica.features.infrastructure.repository.BetService
import com.prueba.tecnica.features.infrastructure.repository.response.BetItemResponse
import com.prueba.tecnica.features.infrastructure.repository.response.BetResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.kotlin.whenever
import retrofit2.Response



class BetDataSourceImplTest {

    private lateinit var apiService: BetService
    private lateinit var repository: BetDataSourceImpl

    @Before
    fun setUp() {
        apiService = Mockito.mock(BetService::class.java)
        repository = BetDataSourceImpl(apiService) // Inyección del servicio mockeado
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getListMatch should return success when API call is successful`() = runTest {
        // Respuesta esperada de la API
        val betList = listOf(
            BetItemResponse(
                id = "bet_001",
                matchId = "match_042",
                placedAt = "2026-02-12T19:25:00-05:00",
                pick = "AWAY",
                odd = 5.35,
                stake = 30.0,
                status = "LOST",
                returnAmount = 3.50

            )
        )

        val responseBody = BetResponse().apply {
            bets = betList
        }

        val apiResponse = Response.success(responseBody)

        // Simular la llamada exitosa a la API
        whenever(apiService.getAllBets())
            .thenReturn(apiResponse)

        // Ejecutar la función
        val result = repository.getListBet()
        // Validar que el resultado es `Result.Success`
        assert(result is Result.Success)
        val successResult = result as Result.Success
        val firstTransaction = successResult.data.bets


        assertEquals(true, firstTransaction.isNotEmpty())
        // Verificar que si llamo al listado fue llamado
        verify(apiService).getAllBets()
    }



    @Test
    fun `getListBets should return error when API call fails with 400`() = runTest {
        //Arrange (Preparación)
        val errorJson = """
        {
            "message": "Bad Request",
            "code": "400"
        }
    """.trimIndent()

        val errorResponse = Response.error<BetResponse>(
            400,
            errorJson.toResponseBody("application/json".toMediaType())
        )
        // Ejecutar la función  -- Act (Ejecución)
        whenever(apiService.getAllBets()).thenReturn(errorResponse)

        // Verificar que `registerEmail` fue llamado - Assert (Verificación)
        val result = repository.getListBet()
        assertTrue(result is Result.Error)

        val error = result as Result.Error

        verify(apiService).getAllBets()
    }


    @Test
    fun `getListBets should return failure when there is a network error`() = runTest {

        // Simular error de conectividad - Arrange (Preparación)
        whenever(apiService.getAllBets()).thenThrow(RuntimeException("No Internet"))

        // Ejecutar la función  -- Act (Ejecución)
        val result = repository.getListBet()


        // Verificar que el resultado es `Result.Error`- Assert (Verificación)
        assert(result is Result.Error)

        // Verificar que `registerEmail` fue llamado - Assert (Verificación)
        verify(apiService).getAllBets()
    }


}