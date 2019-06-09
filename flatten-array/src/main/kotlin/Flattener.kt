class Flattener {
    companion object {
        fun flatten(l: List<Any?>): List<Int> {
            return mutableListOf<Int>().run {
                flatten(l, this)
                toList()
            }
        }

        private fun flatten(l: List<Any?>, acc: MutableList<Int>): Unit {
           l.forEach {
               it?.apply {
                   if(it is Int) {
                       acc.add(it)
                   } else if(it is List<Any?>){
                       flatten(it, acc)
                   }
               }
           }
        }
    }

}
