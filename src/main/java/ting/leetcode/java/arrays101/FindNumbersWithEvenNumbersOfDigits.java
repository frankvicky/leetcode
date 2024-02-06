package ting.leetcode.java.arrays101;

import com.sun.jdi.Value;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class FindNumbersWithEvenNumbersOfDigits {
    public int findNumbersWithStrings(int[] nums) {
        return (int) (Arrays.stream(nums)
                .mapToObj(Integer::toString)
                .map(String::length)
                .filter(value -> (value & 1) == 0)
                .count());
    }

    public int findNumbers(int[] nums) {
        int countOfEven = 0;
        for (int num : nums) {
            int divider = 1;
            int count = 0;
            while (num % divider != num) {
                divider *= 10;
                count++;
            }
            if ((count & 1) == 0)
                countOfEven++;
        }
        return countOfEven;
    }
}
