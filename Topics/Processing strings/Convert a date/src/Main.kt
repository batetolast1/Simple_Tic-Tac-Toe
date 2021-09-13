fun main() {
    val input = readLine()!!
    val output = input.substringAfter("-").split("-") + input.substringBefore("-")
    print(output.joinToString(separator = "/"))
}