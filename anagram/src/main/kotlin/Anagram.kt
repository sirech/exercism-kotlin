class Anagram(private val s: String) {
    private val normalized = s.normalize()

    fun match(candidates: List<String>): Set<String> {
        return candidates.filter(::isAnagram).toSet()
    }

    private fun isAnagram(candidate: String) = s != candidate.toUpperCase() && candidate.normalize() == normalized

    private fun String.normalize() = toLowerCase().toList().sorted()
}