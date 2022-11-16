package ting.leetcode.hashtable

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class HappyNumberTest {
    private lateinit var happyNumber: HappyNumber

    @BeforeEach
    fun setUp() {
        happyNumber = HappyNumber()
    }

    @Test
    fun isHappy() {
        assertTrue(happyNumber.isHappy(1))
        assertTrue(happyNumber.isHappy(19))
        assertFalse(happyNumber.isHappy(2))
    }
}