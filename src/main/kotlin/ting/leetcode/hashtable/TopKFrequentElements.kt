package ting.leetcode.hashtable

class TopKFrequentElements {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val numsCount = nums.associateBy ({ it }, { nums.count { e -> it == e } }).toList().sortedByDescending { (_, v) -> v }.toMap()
        return numsCount.keys.take(k).toIntArray()
    }
}