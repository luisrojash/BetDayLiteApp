package com.prueba.tecnica.feature.domain.usecase

import com.prueba.tecnica.core.domain.Failure
import com.prueba.tecnica.core.domain.Result
import com.prueba.tecnica.feature.domain.entities.BetListUi
import com.prueba.tecnica.feature.domain.entities.BetStatus
import com.prueba.tecnica.feature.domain.entities.BetUi
import com.prueba.tecnica.feature.domain.repository.BetRepository
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
class BetUseCaseTest {

    private lateinit var repository: BetRepository

    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        repository = Mockito.mock(BetRepository::class.java)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun whenInitService_Success() = runTest {

        //Mock Result

        val mockResultSuccess = BetListUi(
            bets = listOf(
                BetUi(
                    id = "bet_001",
                    matchId = "match_042",
                    sportLeague = "",
                    match = "Arsenal vs LiverPool",
                    playedText = "Apostaste a: Victoria Visitante",
                    oddText = "2.4",
                    amountLabel = "Posible Ganancia",
                    amountValue = "3.5",
                    status = BetStatus.PENDING,

                    )
            )
        )
        //Arrange
        whenever(repository.getListBets())
            .thenReturn(Result.Success(mockResultSuccess))
        val useCase = BetUseCase(repository)

        // Act: Llama al useCase e imprime el resultado
        val result = useCase.invoke()

        // Assert: Verifica que el resultado sea correcto
        assert(result is Result.Success)
        Assert.assertEquals(true, (result as Result.Success).data.bets.isNotEmpty())
    }


    @Test
    fun whenInitServiceCalled_isCustom400BadRequest() = runTest {
        // Mock data
        // Arrange: simular error desde el repository
        whenever(repository.getListBets())
            .thenReturn(
                Result.Error(
                    Failure.BadRequest(
                        code = "400",
                        message = "Default Error"
                    )
                )
            )

        // Crear instancia del UseCase
        val useCase = BetUseCase(repository)

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
        whenever(repository.getListBets())
            .thenReturn(
                Result.Error(
                    Failure.AuthorizationRequired(
                        code = "401",
                        message = "AuthorizationRequired"
                    )
                )
            )


        val useCase = BetUseCase(repository)

        val result = useCase.invoke()

        assert(result is Result.Error)

        val error = (result as Result.Error).error

        assert(error is Failure.AuthorizationRequired)

        val badRequest = error as Failure.AuthorizationRequired
        Assert.assertEquals("AuthorizationRequired", badRequest.message)
    }
}