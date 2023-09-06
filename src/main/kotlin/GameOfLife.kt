class GameOfLife {
    constructor(
        grid: Grid,
        aliveCell : List<Position>
    ){
        this.grid = grid
        this.aliveCell = aliveCell
    }

    private val grid : Grid
    private var aliveCell : List<Position>
}