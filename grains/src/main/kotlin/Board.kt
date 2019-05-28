import java.lang.IllegalArgumentException
import java.math.BigInteger

class Board {
    companion object {
        fun getGrainCountForSquare(i: Int): BigInteger {
            if ( i <= 0 || i > 64) {
                throw IllegalArgumentException("Only integers between 1 and 64 (inclusive) are allowed")
            }
            return BigInteger("2").pow(i-1)
        }

        fun getTotalGrainCount(): BigInteger {
            var current = BigInteger.ONE
            var total = current

            for(i in 2..64) {
                current *= BigInteger("2")
                total += current
            }

            return total
        }
    }
}
