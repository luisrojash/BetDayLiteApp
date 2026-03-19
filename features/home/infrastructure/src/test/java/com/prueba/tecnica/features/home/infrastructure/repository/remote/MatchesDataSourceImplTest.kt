package com.prueba.tecnica.features.home.infrastructure.repository.remote

import com.prueba.tecnica.core.domain.Result
import com.prueba.tecnica.features.home.infrastructure.repository.MatchesService
import com.prueba.tecnica.features.home.infrastructure.repository.response.AwayTeamResponse
import com.prueba.tecnica.features.home.infrastructure.repository.response.BetsResponse
import com.prueba.tecnica.features.home.infrastructure.repository.response.HomeTeamResponse
import com.prueba.tecnica.features.home.infrastructure.repository.response.MarketResponse
import com.prueba.tecnica.features.home.infrastructure.repository.response.MatchesDataResponse
import com.prueba.tecnica.features.home.infrastructure.repository.response.MatchesResponse
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


class MatchesDataSourceImplTest {

    private lateinit var apiService: MatchesService
    private lateinit var repository: MatchesDataSourceImpl

    @Before
    fun setUp() {
        apiService = Mockito.mock(MatchesService::class.java)
        repository = MatchesDataSourceImpl(apiService) // Inyección del servicio mockeado
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getListMatch should return success when API call is successful`() = runTest {
        // Respuesta esperada de la API
        val listMatches = listOf(
            MatchesDataResponse(
                id = "match_001",
                startTime = "2026-02-12T00:00:00-05:00",
                homeTeam = HomeTeamResponse(
                    id = "bha",
                    name = "Brighton",
                    shortName = "BHA"
                ),
                awayTeam = AwayTeamResponse(
                    id = "bre",
                    name = "Brentford",
                    shortName = "BRE"
                ),
                market = MarketResponse(
                    type = "1x2",
                    bets = BetsResponse(
                        firstBets = 4.67,
                        secondBets = 5.96,
                        threeBets = 4.44
                    )
                )

            )
        )

        val responseBody = MatchesResponse().apply {
            matches = listMatches
        }

        val apiResponse = Response.success(responseBody)

        // Simular la llamada exitosa a la API
        whenever(apiService.getAllMatches())
            .thenReturn(apiResponse)

        // Ejecutar la función
        val result = repository.getListMatches()
        // Validar que el resultado es `Result.Success`
        assert(result is Result.Success)
        val successResult = result as Result.Success
        val firstTransaction = successResult.data.listMatch


        assertEquals(true, firstTransaction.isNotEmpty())
        // Verificar que si llamo al listado fue llamado
        verify(apiService).getAllMatches()
    }



    @Test
    fun `getListMatch should return error when API call fails with 400`() = runTest {
        //Arrange (Preparación)
        val errorJson = """
        {
            "message": "Bad Request",
            "code": "400"
        }
    """.trimIndent()

        val errorResponse = Response.error<MatchesResponse>(
            400,
            errorJson.toResponseBody("application/json".toMediaType())
        )
        // Ejecutar la función  -- Act (Ejecución)
        whenever(apiService.getAllMatches()).thenReturn(errorResponse)

        // Verificar que `registerEmail` fue llamado - Assert (Verificación)
        val result = repository.getListMatches()
        assertTrue(result is Result.Error)

        val error = result as Result.Error

        verify(apiService).getAllMatches()
    }


    @Test
    fun `getListMatch should return failure when there is a network error`() = runTest {

        // Simular error de conectividad - Arrange (Preparación)
        whenever(apiService.getAllMatches()).thenThrow(RuntimeException("No Internet"))

        // Ejecutar la función  -- Act (Ejecución)
        val result = repository.getListMatches()


        // Verificar que el resultado es `Result.Error`- Assert (Verificación)
        assert(result is Result.Error)

        // Verificar que `registerEmail` fue llamado - Assert (Verificación)
        verify(apiService).getAllMatches()
    }


}