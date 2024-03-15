package leetcode.hashtable

import kotlin.time.Duration.Companion.seconds

class SingleNumber {
    fun singleNumber(nums: IntArray): Int = nums.groupBy { it }.minWith(compareBy { it.value.size }).key
    fun singleNumberMinBy(nums: IntArray): Int = nums.groupBy { it }.minBy { it.value.size }.key
    fun singleNumberXor(nums: IntArray): Int = nums.fold(0) { acc, next -> acc xor next }
}
