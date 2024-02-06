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
}
