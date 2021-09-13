package tictactoe

fun main() {
    printEnterCells()
    val input = readLine()!!
    val board = Board(input)
    board.printBoard()
    while (true) {
        printTheCoordinates()
        val coordinates = readLine()!!.split("\\s+".toRegex())

        if (coordinates.all { it in listOf("1", "2", "3") } && coordinates.size == 2) {
            if (board.canMakeMove(coordinates.map { it.toInt() })) {
                board.makeMove(coordinates.map { it.toInt() })
                board.printBoard()
                return
            } else {
                println("This cell is occupied! Choose another one!")
            }
        } else if (coordinates.all { it.matches("\\d+".toRegex()) }) {
            println("Coordinates should be from 1 to 3!")
        } else {
            println("You should enter numbers!")
        }
    }
}

fun printEnterCells() {
    print("Enter cells: ")
}

fun printTheCoordinates() {
    print("Enter the coordinates: ")
}
