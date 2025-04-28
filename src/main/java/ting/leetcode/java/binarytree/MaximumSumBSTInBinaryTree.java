package ting.leetcode.java.binarytree;

public class MaximumSumBSTInBinaryTree {
    private int maxSum;

    public int maxSumBST(TreeNode root) {
        findMaxMinSum(root);
        return maxSum;
    }

    /**
     * @param root
     * @return size 4 int array
     * <p>
     *     <ol>
     *         <li>1: is valid bst, 0: not bst</li>
     *         <li>min value of bst</li>
     *         <li>max value of bst</li>
     *         <li>subtree node value sum</li>
     *     </ol>
     * </p>
     */
    int[] findMaxMinSum(TreeNode root) {
        if (root == null) {
            return new int[] {1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = findMaxMinSum(root.left);
        int[] right = findMaxMinSum(root.right);

        int[] res = new int[4];
        if (left[0] == 1 && right[0] == 1 &&
            root.val > left[2] && root.val < right[1]) {
            res[0] = 1;
            res[1] = Math.min(left[1], root.val);
            res[2] = Math.max(right[2], root.val);
            res[3] = left[3] + right[3] + root.val;
            maxSum = Math.max(maxSum, res[3]);
        } else {
            res[0] = 0;
        }
        return res;
    }
}