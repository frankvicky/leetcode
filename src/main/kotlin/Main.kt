import ting.leetcode.arrayandstring.FindPivotIndex
import ting.leetcode.arrayandstring.LargestNumberAtLeastTwiceOfOthers
import ting.leetcode.arrays101.*
import ting.leetcode.beginnerguide.FindAllNumbersDisappearedInAnArray
import ting.leetcode.beginnerguide.RansomNote
import ting.leetcode.beginnerguide.ThirdMaximumNumber

fun main(args: Array<String>) {
    val solution = PlusOne()
//    val numbers = intArrayOf(1,1)
//    val numbers = intArrayOf(1,7,3,6,5,6)
//    val numbers = intArrayOf(9,8,7,6,5,4,3,2,1,0)
    val numbers = intArrayOf(0,1,2,9)
//    println(numbers.joinToString(""))
//    val numbers = intArrayOf(1, 2, 3)
//    val numbers = listOf(17,18,5,4,6,1)
    println(solution.plusOneSimpleSolution(numbers).contentToString())
//    println(solution.replaceElements(intArrayOf(17,18,5,4,6,1)).contentToString())

}
