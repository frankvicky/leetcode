package ting.leetcode.arrays101

class MergeSortedArray {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        if (m == 0) {
            for (i in 0..nums1.lastIndex) {
                nums1[i] = nums2[i]
            }
            nums1.sort()
            return
        }

        if (n == 0) {
            nums1.sort()
            return
        }

        nums1.sort()
        val zeroStartIndex = nums1.indexOf(0)

        for (i in 0..nums2.lastIndex) {
            nums1[i + zeroStartIndex] = nums2 [i]
        }
        nums1.sort()
    }
}