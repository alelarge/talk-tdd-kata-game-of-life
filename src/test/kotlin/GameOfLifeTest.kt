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

    @Test
    fun `at the start of the game game of life, if I have no living cells then the game is over`(){
        val grid = Grid(3, 3)
        val game = Game(grid, emptyList<Position>())
        assertThat(game.isOver()).isTrue
    }

    @Test
    fun `at the beginning of the game game of life, if you have living cells, the game continues`(){
        val grid = Grid(3, 3)
        val game = Game(grid, listOf(Position(0,0)))
        assertThat(game.isOver()).isFalse
    }

    @Test
    fun`at the start of the game game of life, if I have a living cell, then at the next turn, the game is over`(){
        //Given
        val grid = Grid(3, 3)
        val game = Game(grid, listOf(Position(0,0)))

        // When
        game.play()

        //Then
        assertThat(game.isOver()).isTrue
    }

    @Test
    fun `horizontal cells evolve into vertical cells in the next generation`() {
        //Given
        val grid = Grid(3, 3)
        val initialAliveCells = listOf(
            Position(1, 0), Position(1, 1), Position(1, 2)
        )
        //When
        val game = Game(grid, initialAliveCells)
        //Then

        assertThat(game.getCellAtPosition(Position(1, 0)).isAlive()).isEqualTo(CellState.ALIVE)
        assertThat(game.getCellAtPosition(Position(1, 1)).isAlive()).isEqualTo(CellState.ALIVE)
        assertThat(game.getCellAtPosition(Position(1, 2)).isAlive()).isEqualTo(CellState.ALIVE)

        game.play()

        assertThat(game.getCellAtPosition(Position(0, 1)).isAlive()).isEqualTo(CellState.ALIVE)
        assertThat(game.getCellAtPosition(Position(1, 1)).isAlive()).isEqualTo(CellState.ALIVE)
        assertThat(game.getCellAtPosition(Position(2, 1)).isAlive()).isEqualTo(CellState.ALIVE)

        assertThat(game.isOver()).isFalse
    }
}






