package ting.leetcode.java.arrays101;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int fast = 0;
        int slow = 0;


        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
