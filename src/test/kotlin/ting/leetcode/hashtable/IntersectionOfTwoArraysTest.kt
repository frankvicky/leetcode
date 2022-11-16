package ting.leetcode.hashtable

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class IntersectionOfTwoArraysTest {
    private lateinit var intersectionOfTwoArrays: IntersectionOfTwoArrays

    @BeforeEach
    fun setUp() {
        intersectionOfTwoArrays = IntersectionOfTwoArrays()
    }

    @Test
    fun intersection() {
        val nums1 = intArrayOf(1, 2, 2, 1)
        val nums2 = intArrayOf(2, 2)
        assertTrue(
            intersectionOfTwoArrays.intersection(nums1, nums2) contentEquals intArrayOf(2)
        )
    }
}