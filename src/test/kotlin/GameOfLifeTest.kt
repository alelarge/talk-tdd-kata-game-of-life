import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameOfLifeTest {
    @Test
    fun `cell should be alive when initialized as alive`(){
        val aliveCell = GameOfLife.Cell(GameOfLife.CellState.ALIVE)
        assertThat(aliveCell.isAlive()).isTrue
    }

    @Test
    fun`cell should be dead when initialized as dead`(){
        val deadCell = GameOfLife.Cell(GameOfLife.CellState.DEAD)
        assertThat(deadCell.isAlive()).isFalse
    }
}