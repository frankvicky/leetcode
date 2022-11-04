import ting.leetcode.arrayandstring.AddBinary
import ting.leetcode.arrayandstring.DiagonalTraverse
import ting.leetcode.arrayandstring.PlusOne
import ting.leetcode.arrayandstring.SpiralMatrix

fun main(args: Array<String>) {
    val solution = AddBinary()
//    val numbers = intArrayOf(1,1)
//    val numbers = intArrayOf(1,7,3,6,5,6)
//    val numbers = intArrayOf(9,8,7,6,5,4,3,2,1,0)
//    val numbers = intArrayOf(0,1,2,9)
//    val twoDimensionArray = arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6), intArrayOf(7,8,9))
//    println(numbers.joinToString(""))
//    val numbers = intArrayOf(1, 2, 3)
//    val numbers = listOf(17,18,5,4,6,1)
//    println(solution.plusOneSimpleSolution(numbers).contentToString())
    println("10101".toBigInteger(2))
    println(solution.addBinary("11", "1"))
    println(solution.addBinary("0", "0"))
    println(solution.addBinary("1010", "1011"))
}
