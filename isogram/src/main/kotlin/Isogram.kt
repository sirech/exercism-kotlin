class Isogram {
    companion object {
        fun isIsogram(s: String): Boolean {
            return s.toLowerCase()
                    .groupBy { it }
                    .filterKeys { it !in listOf('-', ' ') }
                    .values
                    .map { it.count() }
                    .all { it <= 1 }
        }
    }
}
