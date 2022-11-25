package ting.leetcode.hashtable

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TopKFrequentElementsTest {
    private lateinit var topKFrequentElements: TopKFrequentElements

    @BeforeEach
    fun setUp() {
        topKFrequentElements = TopKFrequentElements()
    }

    @Test
    fun topKFrequent() {
        assertArrayEquals(topKFrequentElements.topKFrequent(intArrayOf(4, 4, 4, 5, 5, 6), 2), intArrayOf(4, 5))
        assertArrayEquals(topKFrequentElements.topKFrequent(intArrayOf(4, 5), 2), intArrayOf(4, 5))
    }
}