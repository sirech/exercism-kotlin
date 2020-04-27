object Luhn {

    fun isValid(candidate: String): Boolean {
        if (candidate.length == 1) {
            return false
        }

        if (candidate.any { it !in '0'..'9' }) {
            return false
        }

        val numbers = candidate
                .filter { it in '0'..'9' }
                .map { it.toInt() - '0'.toInt() }

        val sum = numbers
                .reversed()
                .mapIndexed { index, number ->
                    if (index % 2 == 0)
                        number
                    else
                        number.double()
                }
                .sum()

        return sum % 10 == 0
    }

    fun Int.double() = (this * 2).let {
        if (it > 9)
            it - 9
        else
            it
    }
}
