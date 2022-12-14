package ting.leetcode.java.hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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