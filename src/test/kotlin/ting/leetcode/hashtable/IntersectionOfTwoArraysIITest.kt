package ting.leetcode.hashtable

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class IntersectionOfTwoArraysIITest {
    private lateinit var intersectionOfTwoArraysII: IntersectionOfTwoArraysII

    @BeforeEach
    fun setUp() {
        intersectionOfTwoArraysII = IntersectionOfTwoArraysII()
    }

    @Test
    fun intersect() {
        assertTrue(
            intersectionOfTwoArraysII.intersect(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)) contentEquals intArrayOf(2, 2)
        )

        assertTrue(
            intersectionOfTwoArraysII.intersect(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4)) contentEquals intArrayOf(4, 9)
        )
    }
}