fun main() {
    val size = readLine()!!.toInt()
    val mutList: MutableList<Int> = mutableListOf()
    for (i in 0 until size) {
        mutList.add(readLine()!!.toInt())
    }
    print(mutList.indexOfFirst { it == mutList.maxOrNull() })
}