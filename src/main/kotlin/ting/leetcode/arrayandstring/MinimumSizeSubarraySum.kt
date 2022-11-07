package ting.leetcode.arrayandstring

class MinimumSizeSubarraySum {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
//        if (nums.sum() < target) return 0
//        if (nums.max() >= target) return 1
//        for (i)
        return 0
    }

    fun minSubArrayLenWithWindowed(target: Int, nums: IntArray): Int {
        // TODO: need a fast solution
        if (nums.sum() < target) return 0
        val max = nums.max()!!
        if (max >= target) return 1
        val numsList = nums.toList()
        for (i in 2..numsList.size) {
            if (numsList.windowed(i).map { it.sum() }.any { it >= target }) return i
        }
        return 0
    }
}

//numsList.windowed(i).partition { it.contains(max) }.first.any { it.sum() >= target }