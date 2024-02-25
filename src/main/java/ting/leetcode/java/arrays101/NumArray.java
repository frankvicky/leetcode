package ting.leetcode.java.arrays101;

//303
public class NumArray {
    private final int[] prefixSumArr;

    public NumArray(int[] nums) {
        prefixSumArr = new int[nums.length + 1];
        int sum = 0;
        int index = 1;
        for (int num : nums) {
            sum += num;
            prefixSumArr[index++] = sum;
        }
    }

    public int sumRange(int left, int right) {
        return prefixSumArr[right + 1] - prefixSumArr[left];
    }
}
