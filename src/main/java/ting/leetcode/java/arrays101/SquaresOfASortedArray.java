package ting.leetcode.java.arrays101;

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        final int[] results = new int[nums.length];
        int headIndex = 0;
        int tailIndex = nums.length - 1;
        int cursor = nums.length - 1;
        while (tailIndex >= headIndex) {
            int tailElement = Math.abs(nums[tailIndex]);
            int headElement = Math.abs(nums[headIndex]);
            if (headElement > tailElement) {
                results[cursor] = (int) Math.pow(headElement, 2) ;
                headIndex++;
            } else {
                results[cursor] = (int) Math.pow(tailElement, 2);
                tailIndex--;
            }
            cursor--;
        }
        return results;
    }

    public int[] sortedSquares2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] ans = new int[nums.length];
        int index = nums.length - 1;


        while (left <= right) {
            int rightPow = (int) Math.pow(nums[right], 2);
            int leftPow = (int) Math.pow(nums[left], 2);

            if (rightPow >= leftPow) {
                ans[index] = rightPow;
                right--;
            } else {
                ans[index] = leftPow;
                left++;
            }
            index--;
        }

        return ans;
    }
}
