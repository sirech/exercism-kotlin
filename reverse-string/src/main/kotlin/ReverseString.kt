fun reverse(input: String): String {
    val middle = input.length / 2
    val acc = input.toCharArray()

    (0 until middle).zip((input.length - 1).downTo(middle)).forEach { (left, right) ->
        val tmp = input[left]
        acc[left] = acc[right]
        acc[right] = tmp
    }

    return String(acc)
}
