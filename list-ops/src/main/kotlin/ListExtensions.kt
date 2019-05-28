fun <E> List<E>.customAppend(list: List<E>): List<E> {
    val target = mutableListOf<E>()

    this.forEach { target.add(it) }
    list.forEach { target.add(it) }

    return target
}

fun <E> List<List<E>>.customConcat(): List<E> {
    val target = mutableListOf<E>()

    this.forEach { l ->
        l.forEach {
            target.add(it)
        }
    }

    return target
}

fun <E> List<E>.customFilter(predicate: (E) -> Boolean): List<E> {
    val target = mutableListOf<E>()

    this.forEach {
        if (predicate(it)) {
            target.add(it)
        }
    }

    return target
}

val <E> List<E>.customSize: Int
    get() {
        var counter = 0

        this.forEach { counter++ }

        return counter
    }

fun <E, R> List<E>.customMap(mapper: (E) -> (R)): List<R> {
    val target = mutableListOf<R>()

    this.forEach {
        target.add(mapper(it))
    }

    return target
}

fun <E> List<E>.customReverse(): List<E> {
    val target = mutableListOf<E>()

    for (idx in (size - 1).downTo(0)) {
        target.add(this[idx])
    }

    return target
}

fun <E, R> List<E>.customFoldLeft(initial: R, acc: (R, E) -> R): R {
    var result = initial

    this.forEach {
        result = acc(result, it)
    }

    return result
}

fun <E, R> List<E>.customFoldRight(initial: R, acc: (E, R) -> R): R {
    var result = initial

    for (idx in (size - 1).downTo(0)) {
        result = acc(this[idx], result)
    }

    return result
}

