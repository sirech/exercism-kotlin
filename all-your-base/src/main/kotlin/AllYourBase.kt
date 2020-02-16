import java.lang.IllegalArgumentException

class BaseConverter(private val base: Int, private val digits: IntArray) {
    init {
        if (base < 2) {
            throw IllegalArgumentException("Bases must be at least 2.")
        }

        if (digits.isEmpty()) {
            throw IllegalArgumentException("You must supply at least one digit.")
        }

        if (digits.containsNegativeNumbers()) {
            throw IllegalArgumentException("Digits may not be negative.")
        }

        if (digits.hasLeadingZeros()) {
            throw IllegalArgumentException("Digits may not contain leading zeros.")
        }

        if (digits.any { it >= base }) {
            throw IllegalArgumentException("All digits must be strictly less than the base.")
        }
    }

    fun convertToBase(newBase: Int): IntArray {
        if (newBase < 2) {
            throw IllegalArgumentException("Bases must be at least 2.")
        }

        if (digits.isSingleZero()) {
            return digits
        }

        val newDigits = mutableListOf<Int>()

        var remainder = value()

        while (remainder > 0) {
            newDigits.add(remainder % newBase)
            remainder /= newBase
        }

        return newDigits.reversed().toIntArray()
    }

    private fun value(): Int {
        var result = 0
        var multiplier = 1

        digits.reversed().forEach {
            result += multiplier * it
            multiplier *= base
        }

        return result
    }

    private fun IntArray.isSingleZero() = size == 1 && this[0] == 0
    private fun IntArray.hasLeadingZeros() = size > 1 && this[0] == 0
    private fun IntArray.containsNegativeNumbers() = any { it < 0 }
}
