import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameOfLifeTest {
    @Test
    fun `cell dies when it has less than 2 live neighbours`(){
        val aliveCell = GameOfLife.Cell(GameOfLife.CellState.ALIVE)
        val neighbours = listOf(GameOfLife.Cell(GameOfLife.CellState.ALIVE), GameOfLife.Cell(GameOfLife.CellState.DEAD), GameOfLife.Cell(GameOfLife.CellState.DEAD))
        aliveCell.evolve(neighbours)
        assertThat(aliveCell.isAlive()).isFalse
    }

    @Test
    fun `cell dies when it has more than 3 live neighbors`() {
        val aliveCell = GameOfLife.Cell(GameOfLife.CellState.ALIVE)
        val neighbours = listOf(GameOfLife.Cell(GameOfLife.CellState.ALIVE),
            GameOfLife.Cell(GameOfLife.CellState.ALIVE), GameOfLife.Cell(GameOfLife.CellState.ALIVE),
            GameOfLife.Cell(GameOfLife.CellState.ALIVE)
        )
        aliveCell.evolve(neighbours)
        assertThat(aliveCell.isAlive()).isFalse
    }
}