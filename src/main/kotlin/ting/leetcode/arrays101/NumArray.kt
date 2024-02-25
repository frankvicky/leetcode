package ting.leetcode.arrays101

class NumArray(nums: IntArray) {
    private val prefixSumArr: IntArray = IntArray(nums.size + 1)

    init {
        var sum = 0
        for ((i, num) in nums.withIndex()) {
            sum += num
            prefixSumArr[i + 1] = sum
        }
    }

    fun sumRange(left: Int, right: Int): Int = prefixSumArr[right + 1] - prefixSumArr[left]
}
