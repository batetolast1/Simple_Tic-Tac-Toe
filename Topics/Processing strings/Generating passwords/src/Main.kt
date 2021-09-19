fun main() {
    val (uppercase, lowercase, digits, symbols) = readLine()!!.split("\\s+".toRegex())
        .map { it.toInt() }
    val uppercasePart = (1..uppercase).map { if (it % 2 == 0) 'A' else 'B' }
    val lowercasePart = (1..lowercase).map { if (it % 2 == 0) 'a' else 'b' }
    val digitsPart = (1..digits).map { if (it % 2 == 0) '0' else '1' }
    val leftoversPart = (1..symbols - uppercase - lowercase - digits).map { if (it % 2 == 0) '!' else '@' }
    val password = (uppercasePart + lowercasePart + digitsPart + leftoversPart).joinToString(separator = "")
    print(password)
}
