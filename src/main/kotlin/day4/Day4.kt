package day4

import java.io.File
import kotlin.math.min

fun main() {
    val input = File("input4").readLines()
    val counts = input.map { 1 }.toMutableList()

    var sum = 0

    input.forEachIndexed { index, row ->
        val (identifier, allNums) = row.split(":")
        val (winners, mine) = allNums.split("|").map { it.split(" ").filter { it != "" }.map { it.toInt() } }

        val overlap = winners.intersect(mine)

        for (i in index+1 until min(index + overlap.size + 1, input.size)) {
            counts[i] += counts[index]
        }

    }
    println(counts.sum())


}