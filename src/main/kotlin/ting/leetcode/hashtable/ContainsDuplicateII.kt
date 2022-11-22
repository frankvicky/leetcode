package ting.leetcode.hashtable

import kotlin.math.abs

class ContainsDuplicateII {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = HashMap<Int, Int>()
        nums.forEachIndexed { index, value ->
            if (map[value]?.let { abs(it - index) <= k } == true) return true
            map[value] = index
        }
        return false
    }

    fun containsNearbyDuplicateBrute(nums: IntArray, k: Int): Boolean {
        return nums
            .withIndex()
            .groupBy({ it.value }, { it.index })
            .asSequence()
            .filter { it.value.size > 1 }
            .any { (_, v) -> v.windowed(2) {
                abs(it.first() - it.last())
            } .any { it <= k } }
    }
}