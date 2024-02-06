package ting.leetcode.tree

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

class CountPairsOfSimilarStringsTest {

    private lateinit var solution: CountPairsOfSimilarStrings

    @BeforeEach
    fun setup() {
        solution = CountPairsOfSimilarStrings()
    }

    @Test
    fun similarPairs() {
        val case1 = listOf("aabb","ab","ba").toTypedArray()
        assertEquals(3, solution.similarPairs(case1))
        val case2 = listOf("aba","aabb","abcd","bac","aabc").toTypedArray()
        assertEquals(2, solution.similarPairs(case2))
    }
}