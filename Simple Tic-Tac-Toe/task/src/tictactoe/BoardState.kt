package tictactoe

enum class BoardState(val description: String) {

    X_WINS(description = "X wins"),
    O_WINS(description = "O wins"),
    DRAW(description = "Draw"),
    NOT_FINISHED(description = "Game not finished"),
}
