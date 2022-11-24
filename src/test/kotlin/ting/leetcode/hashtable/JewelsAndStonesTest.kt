package ting.leetcode.hashtable

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class JewelsAndStonesTest {
    private lateinit var jewelsAndStones: JewelsAndStones

    @BeforeEach
    fun setUp() {
        jewelsAndStones = JewelsAndStones()
    }

    @Test
    fun numJewelsInStones() {
        assertEquals(jewelsAndStones.numJewelsInStones("aA", "aAAbbbb"), 3)
        assertEquals(jewelsAndStones.numJewelsInStones("z", "ZZ"), 0)
    }

    @Test
    fun numJewelsInStonesWithMap() {
        assertEquals(jewelsAndStones.numJewelsInStonesWithMap("aA", "aAAbbbb"), 3)
        assertEquals(jewelsAndStones.numJewelsInStonesWithMap("z", "ZZ"), 0)
    }
}