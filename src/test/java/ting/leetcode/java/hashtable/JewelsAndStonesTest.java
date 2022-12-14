package ting.leetcode.java.hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JewelsAndStonesTest {
    private JewelsAndStones jewelsAndStones;

    @BeforeEach
    void setUp() {
        jewelsAndStones = new JewelsAndStones();
    }

    @Test
    void numJewelsInStones() {
        assertEquals(jewelsAndStones.numJewelsInStones("aA", "aAAbbbb"), 3);
        assertEquals(jewelsAndStones.numJewelsInStones("z", "ZZ"), 0);
    }

    @Test
    void numJewelsInStonesWithSet() {
        assertEquals(jewelsAndStones.numJewelsInStonesWithList("aA", "aAAbbbb"), 3);
        assertEquals(jewelsAndStones.numJewelsInStonesWithList("z", "ZZ"), 0);
    }
}