class GameOfLife {

    enum class CellState{
        ALIVE,
        DEAD
    }

    class Cell (private var cellState: CellState) {
        private var state = cellState
        fun isAlive() : Boolean {
            return state == CellState.ALIVE
        }
    }

}