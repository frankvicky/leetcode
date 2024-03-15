package ting.leetcode.java.arrays101;

public class FindThePivotInteger {
    public int pivotInteger(int n) {
        if (n == 1)
            return 1;

        int rightSum = 0;
        int left = 0, right = n;
        while (left <= right) {
            rightSum += right;
            while (rightSum - left >= 0) {
                rightSum -= left;
                left++;
            }
            right--;
            if (left == right && rightSum == 0) {
                return left;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new FindThePivotInteger().pivotInteger(15);
    }
}
