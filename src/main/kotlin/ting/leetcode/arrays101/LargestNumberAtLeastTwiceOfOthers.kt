package ting.leetcode.arrays101

class LargestNumberAtLeastTwiceOfOthers {
    fun dominantIndex(nums: IntArray): Int {
        val numsList = nums.sorted()
        if (numsList[nums.lastIndex - 1] * 2 > numsList.last())
            return -1

        return nums.indexOf(numsList.last())
    }

    fun dominantIndexWithTake(nums: IntArray): Int {
        val largestTwo = nums.sorted().takeLast(2)
        if (largestTwo.first() shl 1 > largestTwo.last())
            return -1
        return nums.indexOf(largestTwo.last())
    }

    fun dominantIndexWithHOF(nums: IntArray): Int {
        return nums.run {
            val largestTwo = sorted().takeLast(2)
            if (largestTwo.first() shl 1 > largestTwo.last())
                return -1
            indexOf(largestTwo.last())
        }
    }
}
