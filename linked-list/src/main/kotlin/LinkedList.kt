class Deque<T> {
    inner class Node<T>(val value: T, var next: Node<T>?, var previous: Node<T>?)

    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    private fun isEmpty() = head == null

    fun push(value: T) {
        val node = Node(value, null, null)
        if (isEmpty()) {
            head = node
            tail = node
        } else {
            tail?.next = node
            node.previous = tail
            tail = node
        }
    }

    fun pop(): T? {
        if (isEmpty())
            return null

        val value = tail!!.value

        if (head == tail) {
            head = null
            tail = null
        } else {
            tail = tail?.previous
            tail?.next = null
        }

        return value
    }

    fun unshift(value: T) {
        val node = Node(value, null, null)
        if (isEmpty()) {
            head = node
            tail = node
        } else {
            node.next = head
            head?.previous = node
            head = node
        }
    }

    fun shift(): T? {
        if (isEmpty())
            return null

        val value = head?.value

        if (head == tail) {
            head = null
            tail = null
        } else {
            head = head?.next
        }

        return value
    }
}
