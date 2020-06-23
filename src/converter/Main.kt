package converter

import java.util.Scanner


fun main() {
    val scanner = Scanner(System.`in`)

    println("Enter what you want to convert (or exit): ")
    val line = scanner.next()
    if (line == "exit") return

    val number = line.toDouble()
    val measure = scanner.next()
    scanner.next()
    val targetM = scanner.next()

    println(measure.convertTo(number, true, targetM, true))

    main()
}

fun String.convertTo(n: Double,
                     convert: Boolean = false,
                     targetM: String = "",
                     firstCall: Boolean = false): String {

    fun s(num: Double = n) = if (num != 1.0) "s" else ""
    val es = if (n != 1.0) "es" else ""

    val input = if (convert) this.convertTo(n) else ""

    val distance = when (this.toLowerCase()) {
        "m", "meter", "meters" ->
            if (convert) {
                val targetFormat = targetM.convertTo(n).split(" ")
                val new = s(targetFormat[0].toDouble())
                val out = when (targetFormat[1]) {
                    "meter$new" -> "$n"
                    "kilometer$new" -> "${n / 1000}"
                    "centimeter$new" -> "${n * 100}"
                    "millimeter$new" -> "${n * 1000}"
                    "yard$new" -> "${n / 0.9144}"
                    "mile$new" -> "${n / 1609.35}"
                    "inch", "inches" -> "${n / 0.0254}"
                    "feet", "foot" -> "${n / 0.3048}"
                    else -> ""
                }
                return if (firstCall)
                    "$input is " else {
                    ""
                } + targetFormat[1].convertTo(out.toDouble())
            } else "$n meter${s()}"
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

    val weights = when (this.toLowerCase()) {
        "g", "gram", "grams" ->
            if (convert) {
                val targetFormat = targetM.convertTo(n).split(" ")
                val new = s(targetFormat[0].toDouble())
                val out = when (targetFormat[1]) {
                    "gram$new" -> "$n"
                    "kilogram$new" -> "${n / 1000}"
                    "milligram$new" -> "${n * 1000}"
                    "pound$new" -> "${n / 453.592}"
                    "ounce$new" -> "${n / 28.3495}"
                    else -> ""
                }
                return if (firstCall)
                    "$input is " else {
                    ""
                } + targetFormat[1].convertTo(out.toDouble())
            } else "$n gram${s()}"
        "kg", "kilogram", "kilograms" ->
            if (convert) "${n * 1000}" else "$n kilogram${s()}"
        "mg", "milligram", "milligrams" ->
            if (convert) "${n * 0.001}" else "$n milligram${s()}"
        "lb", "pound", "pounds" ->
            if (convert) "${n * 453.592}" else "$n pound${s()}"
        "oz", "ounce", "ounces" ->
            if (convert) "${n * 28.3495}" else "$n ounce${s()}"

        else -> ""
    }

    fun baseConvert(u: String, output: String) =
            "$input is " + u.convertTo(
                    output.toDouble(),
                    convert = true,
                    targetM = targetM
            )

    return when {
        !distance.isBlank() -> if (convert) baseConvert("m", distance) else distance
        !weights.isBlank() -> if (convert) baseConvert("g", weights) else weights
        else -> ""
    }
}