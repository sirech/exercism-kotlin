enum class Relationship {

    EQUAL, SUBLIST, SUPERLIST, UNEQUAL

}

private enum class Case {
    EMPTY_CASE,
    FIRST_BIGGER_OR_EQUAL,
    FIRST_SMALLER
}

fun <T> List<T>.relationshipTo(other: List<T>): Relationship {
    return when (case(this, other)) {
        Case.EMPTY_CASE -> emptyCase(this, other)
        Case.FIRST_BIGGER_OR_EQUAL -> generalCase(this, other, Relationship.SUPERLIST)
        Case.FIRST_SMALLER -> generalCase(other, this, Relationship.SUBLIST)
    }
}

private fun <T> case(first: List<T>, second: List<T>): Case {
    if (first.isEmpty() || second.isEmpty()) return Case.EMPTY_CASE
    if (first.size >= second.size) return Case.FIRST_BIGGER_OR_EQUAL
    return Case.FIRST_SMALLER
}

private fun <T> emptyCase(first: List<T>, second: List<T>): Relationship {
    if (first.isEmpty() && second.isEmpty()) return Relationship.EQUAL
    if (first.isEmpty()) return Relationship.SUBLIST
    return Relationship.SUPERLIST
}

private fun <T> generalCase(first: List<T>, second: List<T>, case: Relationship): Relationship {
    for (i in 0..(first.size - second.size)) {
        for (j in 0 until second.size) {
            if (first[i+j] != second[j]) {
                break;
            }

            if (j + 1 == second.size) {
                if (first.size == second.size) return Relationship.EQUAL
                return case;
            }
        }
    }

    return Relationship.UNEQUAL
}

