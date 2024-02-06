package ting.leetcode.recursion

private val record = hashMapOf<Int, Int>()
fun fibonacci(number: Int): Int {
    if (number < 2)
        return number

    record[number]?.let { return it }
    val result = fibonacci(number - 1) + fibonacci(number - 2)
    record.putIfAbsent(number, result)

    return result
}

fun fibonacciWithLoop(number: Int): Int {
    if (number <= 2)
        return number

    var previous = 0
    var current = 1

    for (index in 2..number) {
        val temp = current.also {
            current += previous
        }
        previous = temp
    }
    return current
}

fun main() {
    println(fibonacciWithLoop(3))
    println(fibonacci(3))
}
