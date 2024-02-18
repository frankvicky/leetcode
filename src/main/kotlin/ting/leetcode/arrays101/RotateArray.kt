package ting.leetcode.arrays101

class RotateArray {
    fun rotate(nums: IntArray, k: Int): Unit {
        val k = k % nums.size
        if (k == 0) return
        val list = mutableListOf<Int>()
        list.addAll(nums.toList())
        list.addAll(nums.take(nums.size - k))
        list.subList(nums.size - k, list.size).forEachIndexed { index, value ->
            nums[index] = value
        }
    }
}
