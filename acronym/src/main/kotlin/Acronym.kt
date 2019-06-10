class Acronym {
    companion object {
        fun generate(s: String): String {
            return s.split("""[\s,-]+""".toRegex())
                    .map { it.first() }
                    .map { it.toUpperCase() }
                    .joinToString(separator = "")
        }
    }
}
