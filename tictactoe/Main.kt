package tictactoe

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val grid2D: MutableList<MutableList<Char>> = MutableList(3) { MutableList(3) { ' ' } }
    println(formatBoard(grid2D))

    var currentPlayer = 'X'

    while (true) {
        val move = scanner.nextLine().split(" ")

        val row: Int
        val col: Int
        try {
            row = move[0].toInt()
            col = move[1].toInt()
        } catch (_: NumberFormatException) {
            println("You should enter numbers!")
            continue
        }

        when {
            row !in 1..3 || col !in 1..3 -> println("Coordinates should be from 1 to 3!")
            grid2D[row - 1][col - 1] != ' ' -> println("This cell is occupied! Choose another one!")
            else -> {
                grid2D[row - 1][col - 1] = currentPlayer
                println(formatBoard(grid2D))

                val result = checkGameState(grid2D)
                if (result == "X wins" || result == "O wins" || result == "Draw") {
                    println(result)
                    break
                }

                currentPlayer = if (currentPlayer == 'X') 'O' else 'X'
            }
        }
    }
}

fun formatBoard(grid: MutableList<MutableList<Char>>): String {
    return """
        ---------
        | ${grid[0][0]} ${grid[0][1]} ${grid[0][2]} |
        | ${grid[1][0]} ${grid[1][1]} ${grid[1][2]} |
        | ${grid[2][0]} ${grid[2][1]} ${grid[2][2]} |
        ---------
    """.trimIndent()
}

fun checkGameState(grid: List<List<Char>>): String {
    val lines = listOf(
        grid[0], grid[1], grid[2], // rows
        listOf(grid[0][0], grid[1][0], grid[2][0]), // col 0
        listOf(grid[0][1], grid[1][1], grid[2][1]), // col 1
        listOf(grid[0][2], grid[1][2], grid[2][2]), // col 2
        listOf(grid[0][0], grid[1][1], grid[2][2]), // diag
        listOf(grid[0][2], grid[1][1], grid[2][0])  // anti-diag
    )
    return when {
        lines.any { it.all { c -> c == 'X' } } -> "X wins"
        lines.any { it.all { c -> c == 'O' } } -> "O wins"
        grid.flatten().none { it == ' ' } -> "Draw"
        else -> ""
    }
}
