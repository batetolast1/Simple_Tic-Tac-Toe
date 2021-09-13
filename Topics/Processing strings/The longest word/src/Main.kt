fun main() {
    val words = readLine()!!.split("\\s+".toRegex())
    val longestWorld = words.maxByOrNull { it.length }!!
    print(longestWorld)
}