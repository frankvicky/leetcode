package ting.leetcode.hashtable

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import ting.leetcode.hashtable.ContainsDuplicateII

internal class ContainsDuplicateIITest {
    private lateinit var containsDuplicateII: ContainsDuplicateII

    @BeforeEach
    fun setUp() {
        containsDuplicateII = ContainsDuplicateII()
    }

    @Test
    fun containsNearbyDuplicate() {
        assertFalse(
            containsDuplicateII.containsNearbyDuplicate(intArrayOf(1, 2, 3, 1, 1, 2, 3), 0)
        )
        assertTrue(
            containsDuplicateII.containsNearbyDuplicate(intArrayOf(1, 0, 1, 1), 1)
        )
    }

    @Test
    fun containsNearbyDuplicateBrute() {
        assertFalse(
            containsDuplicateII.containsNearbyDuplicateBrute(intArrayOf(1, 2, 3, 1, 1, 2, 3), 0)
        )
        assertTrue(
            containsDuplicateII.containsNearbyDuplicateBrute(intArrayOf(1, 0, 1, 1), 1)
        )
    }
}