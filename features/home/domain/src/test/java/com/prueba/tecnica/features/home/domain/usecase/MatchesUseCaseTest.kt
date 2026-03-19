package com.prueba.tecnica.features.home.domain.usecase

import com.prueba.tecnica.core.domain.Failure
import com.prueba.tecnica.core.domain.Result
import com.prueba.tecnica.features.home.domain.entities.Bets
import com.prueba.tecnica.features.home.domain.entities.FirstTeam
import com.prueba.tecnica.features.home.domain.entities.ItemMatch
import com.prueba.tecnica.features.home.domain.entities.Market
import com.prueba.tecnica.features.home.domain.entities.MatchesUi
import com.prueba.tecnica.features.home.domain.entities.SecondTeam
import com.prueba.tecnica.features.home.domain.repository.MatchesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class MatchesUseCaseTest {

    private lateinit var repository: MatchesRepository

    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        repository = Mockito.mock(MatchesRepository::class.java)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun whenInitService_Success() = runTest {

        //Mock Result
        val firstTeam = FirstTeam(
            id = "bha",
            name = "Brighton",
            shortName = "BHA"
        )

        val secondTeam = SecondTeam(
            id = "bre",
            name = "Brentford",
            shortName = "BRE"
        )
        val market = Market(
            type = "1x2",
            bets = Bets(
                firstBets = 4.67,
                secondBets = 5.96,
                threeBets = 4.4
            )
        )

        val mockResultSuccess = MatchesUi(
            listMatch = listOf(
                ItemMatch(
                    id = "match_001",
                    startTime = "2026-02-12T00:00:00-05:00",
                    firstTeam = firstTeam,
                    secondTeam = secondTeam,
                    market = market
                )
            )
        )
        //Arrange
        whenever(repository.getListMatches())
            .thenReturn(Result.Success(mockResultSuccess))
        val useCase = MatchesUseCase(repository)

        // Act: Llama al useCase e imprime el resultado
        val result = useCase.invoke()

        // Assert: Verifica que el resultado sea correcto
        assert(result is Result.Success)
        Assert.assertEquals(true, (result as Result.Success).data.listMatch.isNotEmpty())
    }


    @Test
    fun whenInitServiceCalled_isCustom400BadRequest() = runTest {
        // Mock data
        // Arrange: simular error desde el repository
        whenever(repository.getListMatches())
            .thenReturn(
                Result.Error(
                    Failure.BadRequest(
                        code = "400",
                        message = "Default Error"
                    )
                )
            )

        // Crear instancia del UseCase
        val useCase = MatchesUseCase(repository)

        // Act: ejecutar el use case
        val result = useCase.invoke()

        // Assert: validar que el resultado sea un error
        assert(result is Result.Error)

        // Extraer el error
        val error = (result as Result.Error).error

        // Validar que el error sea de tipo BadRequest
        assert(error is Failure.BadRequest)

        // Validar el mensaje del error
        val badRequest = error as Failure.BadRequest
        Assert.assertEquals("Default Error", badRequest.message)
    }


    @Test
    fun whenInitServiceCalled_isCustom401AuthorizationRequired() = runTest {
        // Mock data
        // Arrange: simular error desde el repository
        whenever(repository.getListMatches())
            .thenReturn(
                Result.Error(
                    Failure.AuthorizationRequired(
                        code = "401",
                        message = "AuthorizationRequired"
                    )
                )
            )


        val useCase = MatchesUseCase(repository)

        val result = useCase.invoke()

        assert(result is Result.Error)

        val error = (result as Result.Error).error

        assert(error is Failure.AuthorizationRequired)

        val badRequest = error as Failure.AuthorizationRequired
        Assert.assertEquals("AuthorizationRequired", badRequest.message)
    }
}