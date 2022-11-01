import ting.leetcode.arrays101.*
import ting.leetcode.beginnerguide.RansomNote

fun main(args: Array<String>) {
    val solution = SortArrayByParity()
    val numbers = intArrayOf(17,18,5,4,6,1)
//    val numbers = listOf(17,18,5,4,6,1)
    solution.sortArrayByParity(numbers)
    println(numbers.contentToString())
//    println(solution.replaceElements(intArrayOf(17,18,5,4,6,1)).contentToString())

}
