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

    @Test
    fun `cell stays alive when it has 2 live neighbors`() {
        val aliveCell = GameOfLife.Cell(GameOfLife.CellState.ALIVE)
        val neighbours = listOf(GameOfLife.Cell(GameOfLife.CellState.ALIVE), GameOfLife.Cell(GameOfLife.CellState.ALIVE))
        aliveCell.evolve(neighbours)
        assertThat(aliveCell.isAlive()).isTrue
    }

    @Test
    fun `cell stays alive when it has 3 live neighbors`() {
        val aliveCell = GameOfLife.Cell(GameOfLife.CellState.ALIVE)
        val neighbours = listOf(GameOfLife.Cell(GameOfLife.CellState.ALIVE), GameOfLife.Cell(GameOfLife.CellState.ALIVE),
            GameOfLife.Cell(GameOfLife.CellState.ALIVE)
        )
        aliveCell.evolve(neighbours)
        assertThat(aliveCell.isAlive()).isTrue
    }

    @Test
    fun `dead cell becomes alive when it has exactly three live neighbors`() {
        val deadCell = GameOfLife.Cell(GameOfLife.CellState.DEAD)
        val neighbours = listOf(GameOfLife.Cell(GameOfLife.CellState.ALIVE), GameOfLife.Cell(GameOfLife.CellState.ALIVE),
            GameOfLife.Cell(GameOfLife.CellState.ALIVE)
        )
        deadCell.evolve(neighbours)
        assertThat(deadCell.isAlive()).isTrue
    }

    @Test
    fun `cell with 3 live neighbors survives to the next generation`() {
        //Given
        val aliveCell = GameOfLife.Cell(GameOfLife.CellState.ALIVE)
        val neighbors = List(3) { GameOfLife.Cell(GameOfLife.CellState.ALIVE) }
        val deadNeighbor = GameOfLife.Cell(GameOfLife.CellState.DEAD)

        //When
        neighbors.forEach { aliveCell.addNeighbor(it) }
        aliveCell.addNeighbor(deadNeighbor)
        aliveCell.evolve(neighbors)

        //Then
        assertThat(aliveCell.isAlive()).isTrue
    }
}