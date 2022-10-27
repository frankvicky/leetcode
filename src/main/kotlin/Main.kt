fun main(args: Array<String>) {
    val solution = NumberOfStepsToReduceANumberToZero()
    println(solution.numberOfSteps(17))

    var a = 0
    var b = 0

    for (i in 1..100) {
        a += 3
        b++
    }
    println(a)
    println(b)

}