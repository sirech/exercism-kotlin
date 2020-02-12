object BeerSong {
    fun verses(startBottles: Int, takeDown: Int): String {
        return (startBottles downTo takeDown).flatMap {
            listOf(firstVerse(it), secondVerse(it.oneLess()) + "\n")
        }.joinToString(separator = "\n")
    }

    fun Int.oneLess() = if (this == 0) 99 else this - 1

    fun firstVerse(n: Int) = when (n) {
        0 -> "No more bottles of beer on the wall, no more bottles of beer."
        else -> "${beerOnTheWall(n)}, ${bottlesOfBeer(n)}."
    }

    fun secondVerse(n: Int) = when (n) {
        0 -> "Take it down and pass it around, no more bottles of beer on the wall."
        99 -> "Go to the store and buy some more, ${beerOnTheWall(n)}."
        else -> "Take one down and pass it around, ${beerOnTheWall(n)}."
    }

    fun beerOnTheWall(n: Int) = "${bottlesOfBeer(n)} on the wall"

    fun bottlesOfBeer(n: Int) = "$n ${bottle(n)} of beer"

    fun bottle(n: Int) = when (n) {
        1 -> "bottle"
        else -> "bottles"
    }
}
