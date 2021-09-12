fun main() {
    val size = readLine()!!.toInt()
    val mutList: MutableList<Int> = mutableListOf()
    for (i in 0 until size) {
        mutList.add(readLine()!!.toInt())
    }
    val needed = readLine()!!.split("\\s+".toRegex()).map { it.toInt() }.toMutableList()
    print(if (mutList.containsAll(needed)) "YES" else "NO")
}