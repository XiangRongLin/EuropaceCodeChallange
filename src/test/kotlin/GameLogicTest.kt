import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class GameLogicTest {

    @Test
    fun calculatePoints() {
        val game = Game(
            listOf(
                Frame(1, 4),
                Frame(4,5),
                Frame(6,4),
                Frame(5,5),
                Frame(10),
                Frame(0,1),
                Frame(7,3),
                Frame(6,4),
                Frame(10),
                Frame(2,8,6),
            )
        )

        val gameLogic = GameLogic()
        val points = gameLogic.calculatePoints(game)

        assertEquals(133, points)
    }
}