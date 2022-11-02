package ting.leetcode.arrays101

class HeightChecker {
    fun heightChecker(heights: IntArray): Int {
        var result = 0
        heights.sorted().forEachIndexed { index, value ->
            if (value != heights[index]) {
                result++
            }
        }
        return result
    }
}