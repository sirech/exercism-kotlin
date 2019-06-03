class Robot(private var _gridPosition: GridPosition = GridPosition(0, 0), private var _orientation: Orientation = Orientation.NORTH) {
    val gridPosition: GridPosition get() = _gridPosition
    val orientation: Orientation get() = _orientation

    fun turnLeft(): Unit {
        _orientation = _orientation.turnLeft()
    }

    fun turnRight(): Unit {
        _orientation = _orientation.turnRight()
    }

    fun advance(): Unit {
        _gridPosition = _gridPosition.advance(orientation)
    }

    fun simulate(commands: String): Unit {
        commands.forEach { command ->
            when(command) {
                'R' -> turnRight()
                'L' -> turnLeft()
                'A' -> advance()
            }
        }
    }
}

