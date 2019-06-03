data class GridPosition(val x: Int, val y: Int)

fun GridPosition.advance(o: Orientation) = when(o) {
   Orientation.NORTH -> GridPosition(x, y + 1)
   Orientation.WEST -> GridPosition(x - 1, y)
   Orientation.EAST -> GridPosition(x + 1, y)
   Orientation.SOUTH -> GridPosition(x, y - 1)
}
