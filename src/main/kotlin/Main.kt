import ting.leetcode.arrays101.*
import ting.leetcode.beginnerguide.FindAllNumbersDisappearedInAnArray
import ting.leetcode.beginnerguide.RansomNote
import ting.leetcode.beginnerguide.ThirdMaximumNumber

fun main(args: Array<String>) {
    val solution = FindAllNumbersDisappearedInAnArray()
//    val numbers = intArrayOf(1,1)
    val numbers = intArrayOf(4,3,2,7,8,2,3,1)
//    val numbers = listOf(17,18,5,4,6,1)
    println(solution.findDisappearedNumbers(numbers))
//    println(solution.replaceElements(intArrayOf(17,18,5,4,6,1)).contentToString())

}
