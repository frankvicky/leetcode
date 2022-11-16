package ting.leetcode.hashtable

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TwoSumTest {

    private lateinit var twoSum: TwoSum

    @BeforeEach
    fun setUp() {
        twoSum = TwoSum()
    }

    @Test
    fun twoSum() {
        assertTrue(
            twoSum.twoSum(intArrayOf(2, 7, 11, 15), 9) contentEquals intArrayOf(0, 1)
        )

        assertTrue(
            twoSum.twoSum(intArrayOf(3, 2, 4), 6) contentEquals intArrayOf(1, 2)
        )

        assertTrue(
            twoSum.twoSum(intArrayOf(3, 3), 6) contentEquals intArrayOf(0, 1)
        )
    }
}