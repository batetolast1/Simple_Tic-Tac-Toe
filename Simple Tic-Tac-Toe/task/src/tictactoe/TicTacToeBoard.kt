package tictactoe

const val BOARD_SIZE = 3
const val ALLOWED_INPUT_SIZE = 2

const val PRINT_COORDINATES = "Enter the coordinates: "
const val CELL_OCCUPIED = "This cell is occupied! Choose another one!"
const val INVALID_NUMERIC_COORDINATES = "Coordinates should be from 1 to 3!"
const val INVALID_COORDINATES = "You should enter numbers!"

val WHITESPACE_REGEX = "\\s+".toRegex()
val VALID_COORDINATES_REGEX = "[1-$BOARD_SIZE]".toRegex()
val NUMERIC_REGEX = "\\d+".toRegex()

class TicTacToeBoard : Board {

    private var boardFields: List<MutableList<Field>> = List(BOARD_SIZE) { MutableList(BOARD_SIZE) { Field.EMPTY } }
    private var boardState: BoardState = BoardState.NOT_FINISHED
    private var currentPlayer: Player = Player.X
    private var moveCount = 0

    override fun printBoard() {
        println("-".repeat(BOARD_SIZE * BOARD_SIZE))
        for (i in 0 until BOARD_SIZE) {
            println(boardFields[i].joinToString(prefix = "| ", separator = " ", postfix = " |") { it.value })
        }
        println("-".repeat(BOARD_SIZE * BOARD_SIZE))
    }

    override fun makeNextMove() {
        var isMoveMade = false

        while (!isMoveMade) {
            print(PRINT_COORDINATES)

            val inputList = readLine()!!.split(WHITESPACE_REGEX)
            when {
                isValidInput(inputList) -> isMoveMade = tryMakeMove(inputList)
                isNumericInput(inputList) -> println(INVALID_NUMERIC_COORDINATES)
                else -> println(INVALID_COORDINATES)
            }
        }
    }

    private fun isValidInput(inputList: List<String>) =
        inputList.size == ALLOWED_INPUT_SIZE && inputList.all { it.matches(VALID_COORDINATES_REGEX) }

    private fun isNumericInput(inputList: List<String>) =
        inputList.size == ALLOWED_INPUT_SIZE && inputList.all { it.matches(NUMERIC_REGEX) }

    private fun tryMakeMove(inputList: List<String>): Boolean {
        val row = convertToCoordinate(inputList[0])
        val column = convertToCoordinate(inputList[1])

        return if (canMakeMove(row, column)) {
            boardFields[row][column] = currentPlayer.field
            moveCount++
            checkBoardState(row, column)
            true
        } else {
            println(CELL_OCCUPIED)
            false
        }
    }

    private fun canMakeMove(row: Int, column: Int) = boardFields[row][column] == Field.EMPTY

    private fun checkBoardState(row: Int, column: Int) {
        checkRows(row)
        checkColumns(column)
        checkDiagonal(row, column)
        checkAntidiagonal(row, column)
        checkDraw()
    }

    private fun checkRows(row: Int) {
        for (i in 0 until BOARD_SIZE) {
            if (boardFields[row][i] != currentPlayer.field) {
                break
            }
            if (i == BOARD_SIZE - 1) {
                makeWinner(currentPlayer)
            }
        }
    }

    private fun checkColumns(column: Int) {
        for (i in 0 until BOARD_SIZE) {
            if (boardFields[i][column] != currentPlayer.field) {
                break
            }
            if (i == BOARD_SIZE - 1) {
                makeWinner(currentPlayer)
            }
        }
    }

    private fun checkDiagonal(row: Int, column: Int) {
        if (row == column) {
            for (i in 0 until BOARD_SIZE) {
                if (boardFields[i][i] != currentPlayer.field) {
                    break
                }
                if (i == BOARD_SIZE - 1) {
                    makeWinner(currentPlayer)
                }
            }
        }
    }

    private fun checkAntidiagonal(row: Int, column: Int) {
        if (row + column == BOARD_SIZE - 1) {
            for (i in 0 until BOARD_SIZE) {
                if (boardFields[i][BOARD_SIZE - 1 - i] != currentPlayer.field) {
                    break
                }
                if (i == BOARD_SIZE - 1) {
                    makeWinner(currentPlayer)
                }
            }
        }
    }

    private fun checkDraw() {
        if (moveCount == BOARD_SIZE * BOARD_SIZE && boardState == BoardState.NOT_FINISHED) {
            boardState = BoardState.DRAW
        }
    }

    private fun makeWinner(player: Player) {
        boardState = when (player) {
            Player.X -> BoardState.X_WINS
            Player.O -> BoardState.O_WINS
        }
    }

    override fun changePlayer() {
        currentPlayer = when (currentPlayer) {
            Player.X -> Player.O
            Player.O -> Player.X
        }
    }

    override fun getBoardState() = boardState

    private fun convertToCoordinate(input: String) = input.toInt() - 1
}
