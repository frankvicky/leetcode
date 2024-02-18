package ting.leetcode.arrays101

class FindPivotIndex {
    fun pivotIndex(nums: IntArray): Int {
        for (pivotIndex in nums.indices) {
            var rightSum = 0
            var leftSum = 0
            for (leftIndex in 0 until pivotIndex) {
                leftSum += nums[leftIndex]
            }
            for (rightIndex in (pivotIndex + 1) .. nums.lastIndex) {
                rightSum += nums[rightIndex]
            }
            if (leftSum == rightSum) return pivotIndex
        }
        return -1
    }

    fun pivotIndexWithPivotValue(nums: IntArray): Int {
        val sum = nums.sum()
        var leftSum = 0
        for ((pivotIndex, value) in nums.withIndex()) {
            if (leftSum == sum - value - leftSum) return pivotIndex
            leftSum += value
        }
        return -1
    }
}
