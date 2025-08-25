package tictactoe

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val input = scanner.next()
    val output = """
        ---------
        | ${input[0]} ${input[1]} ${input[2]} |
        | ${input[3]} ${input[4]} ${input[5]} |
        | ${input[6]} ${input[7]} ${input[8]} |
        ---------
    """.trimIndent()

    println(output)

    val grid2D: MutableList<MutableList<Char>> = mutableListOf(
        mutableListOf(input[0], input[1], input[2]),
        mutableListOf(input[3], input[4], input[5]),
        mutableListOf(input[6], input[7], input[8])
    )

    val xCount = input.count { it == 'X' }
    val oCount = input.count { it == 'O' }

    var xWins = false
    var oWins = false

    // Check rows
    for (el in grid2D) {
        if (el.all { it == 'X' }) xWins = true
        if (el.all { it == 'O' }) oWins = true
    }

    // Check columns
    for (col in 0..2) {
        if (grid2D.all { it[col] == 'X' }) xWins = true
        if (grid2D.all { it[col] == 'O' }) oWins = true
    }

    // Check diagonals
    if (grid2D[0][0] == grid2D[1][1] && grid2D[1][1] == grid2D[2][2]) {
        if (grid2D[0][0] == 'X') xWins = true
        if (grid2D[0][0] == 'O') oWins = true
    }
    if (grid2D[0][2] == grid2D[1][1] && grid2D[1][1] == grid2D[2][0]) {
        if (grid2D[0][2] == 'X') xWins = true
        if (grid2D[0][2] == 'O') oWins = true
    }

    when {
        (xWins && oWins) || kotlin.math.abs(xCount - oCount) > 1 -> println("Impossible")
        xWins -> println("X wins")
        oWins -> println("O wins")
        input.contains('_') -> println("Game not finished")
        else -> println("Draw")
    }
}