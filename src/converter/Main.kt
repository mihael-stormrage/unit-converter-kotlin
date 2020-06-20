package converter

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    println("Enter a number of kilometers: ")
    val km = scanner.nextInt()
    println("$km kilometers is ${km * 1000} meters")
}
