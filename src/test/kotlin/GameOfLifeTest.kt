import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameOfLifeTest {
    @Test
    fun `cell should be alive when initialized as alive`(){
        val aliveCell = GameOfLife.Cell(GameOfLife.CellState.ALIVE)
        assertThat(aliveCell.isAlive()).isTrue
    }
}