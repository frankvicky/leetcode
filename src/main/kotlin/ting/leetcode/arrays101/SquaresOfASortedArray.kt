package ting.leetcode.arrays101

class SquaresOfASortedArray {
    fun sortedSquares(nums: IntArray): IntArray {
        var left = 0
        var right = nums.lastIndex
        val ans = IntArray(nums.size)

        for (i in ans.lastIndex downTo 0) {
            val leftPow = nums[left] * nums[left]
            val rightPow = nums[right] * nums[right]
            if (rightPow >= leftPow)
                ans[i] = rightPow.also { right-- }
            else
                ans[i] = leftPow.also { left++ }
        }
        return ans
    }
}
