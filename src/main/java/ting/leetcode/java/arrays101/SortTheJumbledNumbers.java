package ting.leetcode.java.arrays101;

import java.util.Arrays;
import java.util.Comparator;

public class SortTheJumbledNumbers {
    public static int[] sortJumbled(int[] mapping, int[] nums) {
        MappedValue[] mappedValues = new MappedValue[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i], mapped = 0, j = 1;
            do {
                mapped = mapping[value % 10] * j + mapped;
                value /= 10;
                j *= 10;
            } while (value > 0);
            mappedValues[i] = new MappedValue(nums[i], mapped);
        }

        Arrays.sort(mappedValues, Comparator.comparingInt((MappedValue e) -> e.mapped));
        for (int i = 0; i < nums.length; i++) {
            nums[i] = mappedValues[i].origin;
        }
        return nums;
    }

    static class MappedValue {
        int origin;
        int mapped;

        public MappedValue(int origin, int mapped) {
            this.origin = origin;
            this.mapped = mapped;
        }
    }
}
