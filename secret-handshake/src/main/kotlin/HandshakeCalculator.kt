class HandshakeCalculator {
    companion object {
        fun calculateHandshake(i: Int): List<Signal> {
            val result = mutableListOf<Signal>()

            for (range in 1..5) {
                if (i.isSet(range)) {
                    result.process(range)
                }

            }

            return result.toList()
        }

        private fun Int.isSet(pos: Int) = (this and (1 shl (pos - 1))) == (1 shl (pos - 1))

        private fun MutableList<Signal>.process(pos: Int): Unit {
            when (pos) {
                1 -> add(Signal.WINK)
                2 -> add(Signal.DOUBLE_BLINK)
                3 -> add(Signal.CLOSE_YOUR_EYES)
                4 -> add(Signal.JUMP)
                5 -> reverse()
                else -> throw IllegalArgumentException()
            }
        }
    }
}