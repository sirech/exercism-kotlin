class CustomSet(vararg initial: Int) {
    private object Nothing

    private val elements = mutableMapOf<Int, Nothing>()

    constructor(initial: Collection<Int>) : this(*initial.toIntArray())

    init {
        initial.forEach { add(it) }
    }

    fun isEmpty() = elements.isEmpty()

    fun isSubset(other: CustomSet): Boolean {
        return elements.keys.all { other.contains(it) }
    }

    fun isDisjoint(other: CustomSet): Boolean {
        return elements.keys.none { other.contains(it) }
    }

    fun contains(other: Int) = elements.containsKey(other)

    fun intersection(other: CustomSet): CustomSet {
        val shared = elements.keys.filter { other.contains(it) }
        return CustomSet(shared)
    }

    fun add(other: Int) {
        if (!elements.containsKey(other)) {
            elements[other] = Nothing
        }
    }

    override fun equals(other: Any?): Boolean {
        if (other !is CustomSet) {
            return false
        }

        return elements.size == other.elements.size && elements.keys.all { other.contains(it) }
    }

    operator fun plus(other: CustomSet): CustomSet {
        val copy = CustomSet(elements.keys)
        other.elements.keys.forEach { copy.add(it) }
        return copy
    }

    operator fun minus(other: CustomSet): CustomSet {
        return CustomSet(elements.keys.filterNot { other.contains(it) })
    }
}
