package ting.leetcode.arrays101

class RemoveDuplicateFromSortedArray {
    fun removeDuplicates(nums: IntArray): Int {
        val distinctArray = nums.distinct().toIntArray()
        for (i in 0..distinctArray.lastIndex) {
            nums[i] = distinctArray[i]
        }
        return distinctArray.size
    }
}