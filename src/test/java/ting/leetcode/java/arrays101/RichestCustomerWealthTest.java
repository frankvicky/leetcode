package ting.leetcode.java.arrays101;

import ting.leetcode.java.arrays101.RichestCustomerWealth;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RichestCustomerWealthTest {

    private RichestCustomerWealth solution;

    @BeforeEach
    void setUp() {
        solution = new RichestCustomerWealth();
    }

    @Test
    void maximumWealth() {
        var caseResult1 = solution.maximumWealth(
                new int[][] {
                        new int[] { 1, 2, 3 },
                        new int[] { 3, 2, 1 }
                }
        );

        var caseResult2 = solution.maximumWealth(
                new int[][] {
                        new int[] { 1, 5 },
                        new int[] { 3, 7 },
                        new int[] { 3, 5 }
                }
        );

        var caseResult3 = solution.maximumWealth(
                new int[][] {
                        new int[] { 2, 8, 7 },
                        new int[] { 7, 1, 3 },
                        new int[] { 1, 9, 5 }
                }
        );

        assertEquals(6, caseResult1);
        assertEquals(10, caseResult2);
        assertEquals(17, caseResult3);
    }
}