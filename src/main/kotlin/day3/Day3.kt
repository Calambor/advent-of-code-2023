package day3

import java.io.File


fun main() {
    val input = File("input3").readLines()

    val grid = input.map { it.toCharArray() }

    var sum = 0

    for (y in 0 until grid.size) {
        for (x in 0 until grid[0].size) {

            if (!grid[y][x].isDigit() && grid[y][x] != '.'){
                // Find nearby
                val top = grid.getNumber(x, y - 1)
                if (top != null) {
                    sum += top
                } else {
                    grid.getNumber(x - 1, y - 1)?.run { sum += this }
                    grid.getNumber(x + 1, y - 1)?.run { sum += this }
                }
                val bottom = grid.getNumber(x, y + 1)
                if (bottom != null) {
                    sum += bottom
                } else {
                    grid.getNumber(x - 1, y + 1)?.run { sum += this }
                    grid.getNumber(x + 1, y + 1)?.run { sum += this }
                }
                grid.getNumber(x - 1, y)?.run { sum += this }
                grid.getNumber(x + 1, y)?.run { sum += this }
            }

        }
    }
    println(sum)
}

fun List<CharArray>.getNumber(x: Int, y: Int): Int? {
    if (!(x in 0 until this[0].size &&
            y in 0 until this.size)) return null
    if (!this[y][x].isDigit()) return null


    var minX = x
    while (minX > 0 && this[y][minX - 1].isDigit()) {
        minX--
    }
    var maxX = x
    while (maxX < this[0].size - 1 && this[y][maxX + 1].isDigit()) {
        maxX++
    }
    val result = this[y].slice(minX..maxX).joinToString("").toInt()

    return result

}


class Day3 {
}