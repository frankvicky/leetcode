package leetcode.recursion

private val record = hashMapOf<Int, Int>()
fun fibonacci(number: Int): Int {
    if (number < 2)
        return number

    leetcode.recursion.record[number]?.let { return it }
    val result = leetcode.recursion.fibonacci(number - 1) + leetcode.recursion.fibonacci(number - 2)
    leetcode.recursion.record.putIfAbsent(number, result)

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
    println(leetcode.recursion.fibonacciWithLoop(3))
    println(leetcode.recursion.fibonacci(3))
}
