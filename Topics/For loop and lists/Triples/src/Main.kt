fun main() {
    val size = readLine()!!.toInt()
    val mutList: MutableList<Int> = mutableListOf()
    var triples = 0
    for (i in 0 until size) {
        mutList.add(readLine()!!.toInt())
        if (i >= 2 && mutList[i - 2] + 1 == mutList[i - 1] && mutList[i - 1] + 1 == mutList[i]) {
            triples++
        }
    }
    print(triples)
}