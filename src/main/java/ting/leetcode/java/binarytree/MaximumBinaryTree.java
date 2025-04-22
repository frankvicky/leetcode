package ting.leetcode.java.binarytree;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0)
            return null;

        return build(nums, 0, nums.length);
    }

    /**
     * @param nums subarray
     * @param leftBound inclusive
     * @param rightBound exclusive
     * @return root of subtree
     */
    private TreeNode build(int[] nums, int leftBound, int rightBound) {
        if (rightBound - leftBound < 1) {
           return null;
        }

        int maxIndex = leftBound;
        for (int i = leftBound; i < rightBound; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = build(nums, leftBound, maxIndex);
        root.right = build(nums, maxIndex + 1, rightBound);
        return root;
    }
}
