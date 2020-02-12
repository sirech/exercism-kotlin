object ETL {
    fun transform(source: Map<Int, Collection<Char>>): Map<Char, Int> {
        return source.flatMap { (value, chars) ->
            chars.map { char ->
                char.toLowerCase() to value
            }
        }.toMap()
    }
}
