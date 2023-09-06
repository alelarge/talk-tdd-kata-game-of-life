class Grid(private val rows: Int, private val cols: Int) {

    fun getNeighbourPositions(position: Position, scale: Int): Set<Position> {
        val neighbourPositions = mutableSetOf<Position>()

        for (i in -1 * scale..scale) {
            for (j in -1 * scale..scale) {
                if (i == 0 && j == 0) continue
                val newX = position.x + i
                val newY = position.y + j
                if (newX in 0 until rows && newY in 0 until cols) {
                    neighbourPositions.add(Position(newX, newY))
                }
            }
        }
        return neighbourPositions
    }
}