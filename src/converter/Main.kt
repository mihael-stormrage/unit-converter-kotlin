package converter

import java.util.Scanner


fun main() {
    val scanner = Scanner(System.`in`)

    println("Enter a number and a measure of length: ")
    val number = scanner.nextDouble()
    val measure = scanner.next()
    println("${measure.convertToMeters(number, false)} is ${measure.convertToMeters(number)}")
}

fun String.convertToMeters(n: Double, convert: Boolean = true): String {
    fun s(num: Double = n) = if (num != 1.0) "s" else ""
    val es = if (n != 1.0) "es" else ""
    val output = when (this.toLowerCase()) {
        "m", "meter", "meters" -> return "$n meter${s()}"
        "km", "kilometer", "kilometers" ->
            if (convert) "${n * 1000}" else "$n kilometer${s()}"
        "cm", "centimeter", "centimeters" ->
            if (convert) "${n * 0.01}" else "$n centimeter${s()}"
        "mm", "millimeter", "millimeters" ->
            if (convert) "${n * 0.001}" else "$n millimeter${s()}"
        "yd", "yard", "yards" ->
            if (convert) "${n * 0.9144}" else "$n yard${s()}"
        "mi", "mile", "miles" ->
            if (convert) "${n * 1609.35}" else "$n mile${s()}"
        "in", "inch", "inches" ->
            if (convert) "${n * 0.0254}" else "$n inch$es"
        "ft", "foot", "feet" -> when {
            convert -> "${n * 0.3048}"
            n != 1.0 -> "$n feet"
            else -> "$n foot"
        }
        else -> ""
    }
    return if (convert) "$output meter${s(output.toDouble())}" else output
}