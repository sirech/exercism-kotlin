object Bob {
    fun hey(input: String) = when (input.identify()) {
        Sentence.STATEMENT -> "Whatever."
        Sentence.SHOUT -> "Whoa, chill out!"
        Sentence.QUESTION -> "Sure."
        Sentence.FORCEFUL_QUESTION -> "Calm down, I know what I'm doing!"
        Sentence.SILENCE -> "Fine. Be that way!"
    }

    private fun String.identify(): Sentence {
        if (isBlank()) {
            return Sentence.SILENCE
        }

        if (isQuestion()) {
            if (isShout())
                return Sentence.FORCEFUL_QUESTION

            return Sentence.QUESTION
        }

        if (isShout()) {
            return Sentence.SHOUT
        }

        return Sentence.STATEMENT
    }

    private fun String.isShout(): Boolean {
        if (!contains("[A-Z]".toRegex())) {
            return false
        }

        return toUpperCase() == this
    }

    private fun String.isQuestion(): Boolean {
        val trimmed = trim()

        return trimmed[trimmed.length - 1] == '?'
    }
}

enum class Sentence {
    STATEMENT,
    SHOUT,
    QUESTION,
    FORCEFUL_QUESTION,
    SILENCE
}
