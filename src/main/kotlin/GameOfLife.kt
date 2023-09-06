class Game {
    constructor(
        grid: Grid,
        aliveCell: List<Position>
    ) {
        this.grid = grid
        this.aliveCell = aliveCell
    }

    private val grid: Grid
    private var aliveCell: List<Position>

    fun isOver() : Boolean {
        if (aliveCell.isEmpty()) {
            return true
        } else {
            return false
        }
    }
}