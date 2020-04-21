import java.util.*
import kotlin.properties.Delegates

class Reactor<T>() {
    // Your compute cell's addCallback method must return an object
    // that implements the Subscription interface.
    interface Subscription<T> {
        fun cancel()
    }

    interface Cell<T> {
        val value: T
        val descendants: List<Cell<T>>

        fun register(descendant: Cell<T>)

        fun recompute()
        fun triggerCallbacks()
    }

    abstract inner class AbstractCell<T> : Cell<T> {
        override val descendants: MutableList<Cell<T>> = mutableListOf()

        override fun register(descendant: Cell<T>) {
            descendants.add(descendant)
        }
    }

    inner class InputCell<T>(initialValue: T) : AbstractCell<T>() {
        override var value: T by Delegates.observable(initialValue) { property, oldValue, newValue ->
            val visited = mutableListOf<Cell<T>>()
            val nodes = LinkedList<Cell<T>>()
                    .also { it.add(this) }

            while (nodes.isNotEmpty()) {
                val cell = nodes.pop()
                cell.recompute()

                visited.add(cell)
                nodes.addAll(cell.descendants)
            }

            visited.distinct().forEach { cell ->
                cell.triggerCallbacks()
            }
        }

        override fun recompute() {}
        override fun triggerCallbacks() {}
    }

    inner class ComputeCell<T>(private vararg val cells: Cell<T>, private val f: (List<T>) -> T) : AbstractCell<T>() {
        init {
            cells.forEach { it.register(this) }
        }

        override var value = f(cells.map { it.value })
        var lastValue: T = value
        private val callbacks = mutableListOf<Handler<T>>()

        override fun recompute() {
            lastValue = value
            value = f(cells.map { it.value })
        }

        fun addCallback(cb: (T) -> Unit): Subscription<T> {
            return Handler(cb = cb).apply {
                callbacks.add(this)
            }
        }

        override fun triggerCallbacks() {
            if (lastValue != value)
                callbacks.filter { it.active }.forEach { it.cb(value) }
        }
    }

    inner class Handler<T>(var active: Boolean = true, val cb: (T) -> Unit) : Subscription<T> {
        override fun cancel() {
            active = false
        }
    }
}

