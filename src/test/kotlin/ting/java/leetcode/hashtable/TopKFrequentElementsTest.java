package ting.java.leetcode.hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopKFrequentElementsTest {
    private TopKFrequentElements topKFrequentElements;

    @BeforeEach
    void setUp() {
        topKFrequentElements = new TopKFrequentElements();
    }

    @Test
    void topKFrequent() {
        assertArrayEquals(topKFrequentElements.topKFrequent(new int[]{ 4, 4, 4, 5, 5, 6 }, 2), new int[]{ 4, 5 });
        assertArrayEquals(topKFrequentElements.topKFrequent(new int[]{ 4, 5 }, 2), new int[]{ 4, 5 });
    }
}