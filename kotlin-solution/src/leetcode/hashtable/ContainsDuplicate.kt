package leetcode.hashtable

class ContainsDuplicate {
    fun containsDuplicate(nums: IntArray): Boolean = nums.size > nums.toSet().size
}
