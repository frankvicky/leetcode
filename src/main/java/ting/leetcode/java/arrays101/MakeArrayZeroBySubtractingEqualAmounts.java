package ting.leetcode.java.arrays101;

import java.util.Arrays;

public class MakeArrayZeroBySubtractingEqualAmounts {
    public int minimumOperations(int[] nums) {
        return (int) Arrays.stream(nums).distinct().filter(value -> value != 0).count();
    }
}
