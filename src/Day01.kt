fun main() {
    fun <T> List<T>.split(delimeter: T): List<List<T>> {
        val result = mutableListOf<List<T>>()
        var buffer = mutableListOf<T>()
        for (item in this) {
            if (item != delimeter) {
                buffer.add(item)
            } else if (buffer.isNotEmpty()) {
                result.add(buffer)
                buffer = mutableListOf()
            }
        }
        return result
    }

    fun part1(input: List<String>): Int {
        return input.split("")
            .maxOf { elfSnacks -> elfSnacks.sumOf { it.toInt() } }
    }

    fun part2(input: List<String>): Int {
        return input.split("")
            .map { elfSnacks -> elfSnacks.sumOf { it.toInt() } }
            .sortedDescending()
            .take(3)
            .sum()
    }

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
