class GameOfLife {

    enum class CellState {
        ALIVE,
        DEAD
    }

    class Cell(cellState: CellState) {

        private var state = cellState
        fun isAlive(): Boolean {
            return state == CellState.ALIVE
        }

        fun evolve(neighbours: List<Cell>) {
            val numLiveNeighbours = neighbours.count { it.state == CellState.ALIVE }
            if (numLiveNeighbours < 2 || numLiveNeighbours > 3) {
                state = CellState.DEAD
            }
        }
    }
}