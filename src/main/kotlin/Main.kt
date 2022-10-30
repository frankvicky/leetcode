import ting.leetcode.arrays101.DuplicateZeros
import ting.leetcode.arrays101.RemoveElement
import ting.leetcode.beginnerguide.RansomNote

fun main(args: Array<String>) {
    val solution = RemoveElement()
    val inputArr = intArrayOf(4,5)
    solution.removeElement(inputArr, 4)
    println(inputArr.contentToString())
}