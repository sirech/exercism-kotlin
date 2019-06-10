import java.lang.IllegalArgumentException

class Hamming {
    companion object {
        fun compute(s: String, t: String): Int {
            if(s.length != t.length) {
                throw IllegalArgumentException("left and right strands must be of equal length.")
            }
            
            return (s zip t)
                    .filter { (a, b) -> a != b }
                    .count()
        }
    }

}
