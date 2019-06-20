class RotationalCipher(private val i: Int) {
    companion object {
        val startLowerCase = 'a'.toInt()
        val startUpperCase = 'A'.toInt()
    }

    fun encode(s: String): String {
        return s.map {
            when (it.isLetter()) {
                true -> it.advance(i).toChar()
                false -> it
            }
        }.joinToString(separator = "")
    }

    private fun Char.advance(i: Int) = if (isUpperCase()) {
        advanceUpperCase(i)
    } else {
        advanceLowerCase(i)
    }

    private fun Char.advanceLowerCase(i: Int) = advanceImpl(i, startLowerCase)
    private fun Char.advanceUpperCase(i: Int) = advanceImpl(i, startUpperCase)

    private fun Char.advanceImpl(i: Int, start: Int): Int {
        val startOffset = toInt() - start
        val finalOffset = (startOffset + i).rem(26)
        return start + finalOffset
    }
}