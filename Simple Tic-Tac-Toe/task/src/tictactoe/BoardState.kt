package tictactoe

enum class BoardState(val description: String) {

    X_WINS("X wins"),
    O_WINS("O wins"),
    DRAW("Draw"),
    NOT_FINISHED("Game not finished"),
    IMPOSSIBLE("Impossible")
}
