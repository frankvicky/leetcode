package ting.java.leetcode.hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainsDuplicateIITest {
    private ContainsDuplicateII containsDuplicateII;

    @BeforeEach
    void setUp() {
        containsDuplicateII = new ContainsDuplicateII();
    }

    @Test
    void containsNearbyDuplicate() {
        assertFalse(
                containsDuplicateII.containsNearbyDuplicate(new int[] { 1, 2, 3, 1, 1, 2, 3 }, 0)
        );
        assertTrue(
                containsDuplicateII.containsNearbyDuplicate(new int[] { 1, 0, 1, 1 }, 1)
        );
    }
}