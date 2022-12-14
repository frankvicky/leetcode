package ting.leetcode.java.arrays101;

import ting.leetcode.java.arrays101.NumberOfStepsToReduceANumberToZero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfStepsToReduceANumberToZeroTest {

    private NumberOfStepsToReduceANumberToZero solution;

    @BeforeEach
    void setUp() {
        solution = new NumberOfStepsToReduceANumberToZero();
    }

    @Test
    void numberOfSteps() {
        assertEquals(solution.numberOfSteps(14), 6);
        assertEquals(solution.numberOfSteps(8), 4);
    }
}