package ting.leetcode.hashtable

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

internal class SingleNumberTest {
    private lateinit var singleNumber: SingleNumber

    @BeforeEach
    fun setUp(): Unit {
        singleNumber = SingleNumber()
    }

    @Test
    fun singleNumber() {
        assertEquals(
            singleNumber.singleNumber(intArrayOf(2, 2, 1)),
            1
        )

        assertEquals(
            singleNumber.singleNumber(intArrayOf(4, 1, 2, 1, 2)),
            4
        )

        assertEquals(
            singleNumber.singleNumber(intArrayOf(1)),
            1
        )
    }

    @Test
    fun singleNumberXor() {
        assertEquals(
            singleNumber.singleNumberXor(intArrayOf(2, 2, 1)),
            1
        )

        assertEquals(
            singleNumber.singleNumberXor(intArrayOf(4, 1, 2, 1, 2)),
            4
        )

        assertEquals(
            singleNumber.singleNumberXor(intArrayOf(1)),
            1
        )
    }
}