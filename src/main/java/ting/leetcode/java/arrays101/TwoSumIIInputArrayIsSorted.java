package ting.leetcode.java.arrays101;

import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int firstPointer = 0;
        int secondPointer = numbers.length - 1;
        while (numbers[firstPointer] + numbers[secondPointer] != target) {
            if (numbers[firstPointer] + numbers[secondPointer] > target)
                secondPointer--;
            else
                firstPointer++;
        }

        return new int[]{firstPointer + 1, secondPointer + 1};
    }
}
