import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CellTest {
    @Test
    fun `cell dies when it has less than 2 live neighbours`(){
        val aliveCell = Cell(CellState.ALIVE)
        val neighbours = listOf(Cell(CellState.ALIVE), Cell(CellState.DEAD), Cell(CellState.DEAD))
        aliveCell.evolve(neighbours)
        assertThat(aliveCell.isAlive()).isFalse
    }

    @Test
    fun `cell dies when it has more than 3 live neighbors`() {
        val aliveCell = Cell(CellState.ALIVE)
        val neighbours = listOf(Cell(CellState.ALIVE),
            Cell(CellState.ALIVE), Cell(CellState.ALIVE),
            Cell(CellState.ALIVE)
        )
        aliveCell.evolve(neighbours)
        assertThat(aliveCell.isAlive()).isFalse
    }

    @Test
    fun `cell stays alive when it has 2 live neighbors`() {
        val aliveCell = Cell(CellState.ALIVE)
        val neighbours = listOf(Cell(CellState.ALIVE), Cell(CellState.ALIVE))
        aliveCell.evolve(neighbours)
        assertThat(aliveCell.isAlive()).isTrue
    }

    @Test
    fun `cell stays alive when it has 3 live neighbors`() {
        val aliveCell = Cell(CellState.ALIVE)
        val neighbours = listOf(Cell(CellState.ALIVE), Cell(CellState.ALIVE),
            Cell(CellState.ALIVE)
        )
        aliveCell.evolve(neighbours)
        assertThat(aliveCell.isAlive()).isTrue
    }

    @Test
    fun `dead cell becomes alive when it has exactly three live neighbors`() {
        val deadCell = Cell(CellState.DEAD)
        val neighbours = listOf(Cell(CellState.ALIVE), Cell(CellState.ALIVE),
            Cell(CellState.ALIVE)
        )
        deadCell.evolve(neighbours)
        assertThat(deadCell.isAlive()).isTrue
    }

    @Test
    fun `cell with 3 live neighbors survives to the next generation`() {
        //Given
        val aliveCell = Cell(CellState.ALIVE)
        val neighbors = List(3) { Cell(CellState.ALIVE) }
        val deadNeighbor = Cell(CellState.DEAD)

        //When
        neighbors.forEach { aliveCell.addNeighbor(it) }
        aliveCell.addNeighbor(deadNeighbor)
        aliveCell.evolve(neighbors)

        //Then
        assertThat(aliveCell.isAlive()).isTrue
    }

    @Test
    fun `must return all positions of the neighbours of the cell`() {
        // Given
        val grid = Grid(3, 3)
        val cellNeighbourPositions = grid.getNeighbourPositions(Position(1, 1), 1)

        // Then
        val expectedNeighbours = setOf(
            Position(0, 0), Position(0, 1), Position(0, 2),
            Position(1, 0), Position(1, 2),
            Position(2, 0), Position(2, 1), Position(2, 2)
        )
        assertThat(expectedNeighbours.toSet()).isEqualTo(cellNeighbourPositions.toSet())
    }
}