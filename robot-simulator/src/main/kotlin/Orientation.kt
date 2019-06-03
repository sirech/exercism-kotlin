enum class Orientation {

    NORTH, EAST, SOUTH, WEST

}

fun Orientation.turnLeft() = when(this) {
    Orientation.NORTH -> Orientation.WEST
    Orientation.WEST -> Orientation.SOUTH
    Orientation.SOUTH -> Orientation.EAST
    Orientation.EAST -> Orientation.NORTH
}

fun Orientation.turnRight() = when(this) {
    Orientation.NORTH -> Orientation.EAST
    Orientation.EAST -> Orientation.SOUTH
    Orientation.SOUTH -> Orientation.WEST
    Orientation.WEST -> Orientation.NORTH
}
