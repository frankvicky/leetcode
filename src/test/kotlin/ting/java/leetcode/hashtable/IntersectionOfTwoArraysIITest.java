package ting.java.leetcode.hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntersectionOfTwoArraysIITest {

    private IntersectionOfTwoArraysII intersectionOfTwoArraysII;

    @BeforeEach
    void setUp() {
        intersectionOfTwoArraysII = new IntersectionOfTwoArraysII();
    }

    @Test
    void intersect() {
        assertArrayEquals(
                intersectionOfTwoArraysII.intersect(new int[]{ 1, 2, 2, 1 }, new int[]{ 2, 2 }),
                new int[]{ 2, 2 }
        );

        assertArrayEquals(
                intersectionOfTwoArraysII.intersect(new int[]{ 4, 9, 5 }, new int[]{ 9, 4, 9, 8, 4 }),
                new int[]{ 4, 9 }
        );
    }
}