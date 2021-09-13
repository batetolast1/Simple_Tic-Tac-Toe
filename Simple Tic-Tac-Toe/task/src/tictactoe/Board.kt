package tictactoe

import kotlin.math.abs

const val BOARD_SIZE = 3
const val INPUT_LENGTH = BOARD_SIZE * BOARD_SIZE
const val X = 'X'
const val O = 'O'
const val BLANK = '_'
val ALLOWED_VALUES = listOf(X, O, BLANK)

class Board(input: String) {

    private val board: List<CharArray>
    private val boardState: BoardState
    private val input: String
    private val diagonal: CharArray
    private val antiDiagonal: CharArray

    init {
        validate(input)
        board = parse(input)
        diagonal = diagonal()
        antiDiagonal = antiDiagonal()
        this.input = input
        boardState = getBoardState()
    }

    private fun validate(input: String) {
        assert(input.length == INPUT_LENGTH)
        assert(input.all { it in ALLOWED_VALUES })
    }

    private fun diagonal() = charArrayOf(board[0][0], board[1][1], board[2][2])
    private fun antiDiagonal() = charArrayOf(board[0][2], board[1][1], board[2][0])
    private fun parse(input: String) = input.chunked(BOARD_SIZE).map { it.toCharArray() }

    // TODO refactor
    fun printBoard() {
        println("---------")
        println("| ${board[0][0]} ${board[0][1]} ${board[0][2]} |")
        println("| ${board[1][0]} ${board[1][1]} ${board[1][2]} |")
        println("| ${board[2][0]} ${board[2][1]} ${board[2][2]} |")
        println("---------")
        println(boardState.description)
    }

    private fun getBoardState(): BoardState {
        var oCount = 0
        var xCount = 0
        if (abs(input.count { it == X } - input.count { it == O }) > 1) {
            return BoardState.IMPOSSIBLE
        }

        if (diagonal.all { it == X } || antiDiagonal.all { it == X }) {
            xCount++
        }
        if (diagonal.all { it == O } || antiDiagonal.all { it == O }) {
            oCount++
        }

        for (i in 0 until BOARD_SIZE) {
            if (board[i].all { it == X }) {
                xCount++
            }
            if (board[i].all { it == O }) {
                oCount++
            }

            if (board[0][i] == X && board[1][i] == X && board[2][i] == X) {
                xCount++
            }
            if (board[0][i] == O && board[1][i] == O && board[2][i] == O) {
                oCount++
            }
        }

        if (xCount + oCount > 1) {
            return BoardState.IMPOSSIBLE
        }

        if (xCount == 1) {
            return BoardState.X_WINS
        }
        if (oCount == 1) {
            return BoardState.O_WINS
        }

        if (input.count { it == X } + input.count { it == O } == 9) {
            return BoardState.DRAW
        }

        return BoardState.NOT_FINISHED
    }

    fun canMakeMove(coordinates: List<Int>): Boolean {
        val x = coordinates[0] - 1
        val y = coordinates[1] - 1
        return board[x][y] == BLANK
    }

    fun makeMove(coordinates: List<Int>) {
        val x = coordinates[0] - 1
        val y = coordinates[1] - 1
        board[x][y] = X
    }
}
