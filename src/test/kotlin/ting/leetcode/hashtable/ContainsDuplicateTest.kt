package ting.leetcode.hashtable

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class ContainsDuplicateTest() {
    private lateinit var containsDuplicate: ContainsDuplicate

    @BeforeEach
    fun setUp(): Unit {
        containsDuplicate = ContainsDuplicate()
    }

    @Test
    fun containsDuplicate(): Unit {
        assertTrue(
            containsDuplicate.containsDuplicate(intArrayOf(1, 2, 3, 1))
        )
    }
}