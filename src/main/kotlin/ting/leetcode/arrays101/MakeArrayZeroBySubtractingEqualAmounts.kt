package ting.leetcode.arrays101

class MakeArrayZeroBySubtractingEqualAmounts {
    fun minimumOperations(nums: IntArray): Int = (nums.toSet() - 0).size
}