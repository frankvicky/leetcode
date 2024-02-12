package ting.leetcode.java.arrays101;

public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (numbers[left] + numbers[right] != target) {
            int sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            }
        }

        return new int[] { left + 1, right + 1 };
    }
}
