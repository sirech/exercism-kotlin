class Pangram {
    companion object {
        fun isPangram(s: String): Boolean {
            return s.toLowerCase().run {
                alphabet().all { it in this }
            }
        }

        private fun alphabet() = 'a'..'z'
    }
}