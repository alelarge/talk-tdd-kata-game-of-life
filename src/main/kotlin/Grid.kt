class Grid(private val rows: Int, private val cols: Int) {

    fun getNeighbourPositions(position: Position, scale: Int): MutableSet<Position> {
        val neighbourPositions = mutableSetOf<Position>()
        return neighbourPositions
    }
}