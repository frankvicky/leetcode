package ting.leetcode.hashtable

import kotlin.math.min

class IntersectionOfTwoArraysII {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val intersectNums = nums1 intersect nums2.toSet()
        val resultList = mutableListOf<Int>()
        intersectNums.forEach { value ->
            val occurrences = min(nums1.count { it == value }, nums2.count { it == value })
            resultList.addAll(List(occurrences) { value })
        }
        return resultList.toIntArray()
    }
}