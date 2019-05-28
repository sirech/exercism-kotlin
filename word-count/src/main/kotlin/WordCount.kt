class WordCount {
    companion object {
        fun phrase(s: String): Map<String, Int> {
            return tokenize(s)
                    .map(::sanitize)
                    .groupBy { it }
                    .mapValues { (_, v) -> v.size }
        }

        private fun tokenize(s: String): List<String> {
            return s.split("""[\s,]+""".toRegex())
        }

        private fun sanitize(s: String): String {
            return s
                    .toLowerCase()
                    .replace("""[.:!&@$%^]""".toRegex(), "")
                    .trim('\'')
        }
    }
}
