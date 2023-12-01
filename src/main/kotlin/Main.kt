import java.io.File


fun main(args: Array<String>) {

    val input = File("input_1.txt").readLines()
    val validEntries = listOf(
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine",
        "1", "2", "3", "4", "5", "6", "7", "8", "9")

    val answer = input.map { line ->
        val foundFirst = line.findAnyOf(validEntries)!!
        val foundLast = line.findLastAnyOf(validEntries)!!

        val number = (foundFirst.second.readNumber() +  foundLast.second.readNumber()).toInt()
        number
    }.sum()
    println(answer)
}

fun String.readNumber(): String = when(this) {
    "one" -> "1"
    "two" -> "2"
    "three" -> "3"
    "four" -> "4"
    "five" -> "5"
    "six" -> "6"
    "seven" -> "7"
    "eight" -> "8"
    "nine" -> "9"
    else -> this
}