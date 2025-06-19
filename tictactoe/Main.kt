package tictactoe

import java.util.Scanner

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
}