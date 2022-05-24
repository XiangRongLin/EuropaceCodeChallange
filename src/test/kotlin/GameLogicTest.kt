import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

internal class GameLogicTest {

    @Test
    fun invalidNumberOfFrames() {
        val game = Game(listOf(Frame(1)))
        val gameLogic = GameLogic()

        assertThrows<IllegalStateException> {
            gameLogic.calculatePoints(game)
        }
    }

    @Test
    fun invalidFrame() {
        val game = Game(
            listOf(
                Frame(1, 4, 1),
                Frame(4, 5),
                Frame(6, 4),
                Frame(5, 5),
                Frame(10),
                Frame(0, 1),
                Frame(7, 3),
                Frame(6, 4),
                Frame(10),
                Frame(2, 8, 6),
            )
        )
        val gameLogic = GameLogic()

        assertThrows<IllegalStateException> {
            gameLogic.calculatePoints(game)
        }
    }

    @Test
    fun normalGame() {
        val game = Game(
            listOf(
                Frame(1, 4),
                Frame(4, 5),
                Frame(6, 4),
                Frame(5, 5),
                Frame(10),
                Frame(0, 1),
                Frame(7, 3),
                Frame(6, 4),
                Frame(10),
                Frame(2, 8, 6),
            )
        )

        val gameLogic = GameLogic()
        val points = gameLogic.calculatePoints(game)

        assertEquals(133, points)
    }

    @Test
    fun spareInLastFrame() {
        val game = Game(
            listOf(
                Frame(0, 0),
                Frame(0, 0),
                Frame(0, 0),
                Frame(0, 0),
                Frame(0, 0),
                Frame(0, 0),
                Frame(0, 0),
                Frame(0, 0),
                Frame(0, 0),
                Frame(1, 9, 1),
            )
        )

        val gameLogic = GameLogic()
        val points = gameLogic.calculatePoints(game)

        assertEquals(11, points)
    }

    @Test
    fun strikeInLastFrame() {
        val game = Game(
            listOf(
                Frame(0, 0),
                Frame(0, 0),
                Frame(0, 0),
                Frame(0, 0),
                Frame(0, 0),
                Frame(0, 0),
                Frame(0, 0),
                Frame(0, 0),
                Frame(0, 0),
                Frame(10, 1),
            )
        )

        val gameLogic = GameLogic()
        val points = gameLogic.calculatePoints(game)

        assertEquals(11, points)
    }

    @Test
    fun spareAtSecondLast() {
        val game = Game(
            listOf(
                Frame(0, 0),
                Frame(0, 0),
                Frame(0, 0),
                Frame(0, 0),
                Frame(0, 0),
                Frame(0, 0),
                Frame(0, 0),
                Frame(0, 0),
                Frame(1, 9),
                Frame(5, 0),
            )
        )

        val gameLogic = GameLogic()
        val points = gameLogic.calculatePoints(game)

        assertEquals(20, points)
    }

    @Test
    fun tripleStrike() {
        val game = Game(
            listOf(
                Frame(10),
                Frame(10),
                Frame(10),
                Frame(0, 0),
                Frame(0, 0),
                Frame(0, 0),
                Frame(0, 0),
                Frame(0, 0),
                Frame(0, 0),
                Frame(0, 0),
            )
        )

        val gameLogic = GameLogic()
        val points = gameLogic.calculatePoints(game)

        assertEquals(60, points)
    }

    @Test
    fun tripleStrikeAtEnd() {
        val game = Game(
            listOf(
                Frame(0, 0),
                Frame(0, 0),
                Frame(0, 0),
                Frame(0, 0),
                Frame(0, 0),
                Frame(0, 0),
                Frame(0, 0),
                Frame(0, 0),
                Frame(10),
                Frame(10, 10),
            )
        )

        val gameLogic = GameLogic()
        val points = gameLogic.calculatePoints(game)

        assertEquals(50, points)
    }
}