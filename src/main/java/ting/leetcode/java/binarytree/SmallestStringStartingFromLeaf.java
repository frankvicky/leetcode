package ting.leetcode.java.binarytree;

public class SmallestStringStartingFromLeaf {
    private final StringBuilder stringBuilder = new StringBuilder();
    private String res = null ;

    public String smallestFromLeaf(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        stringBuilder.append((char) ('a' + root.val));

        if (root.left == null && root.right == null) {
            stringBuilder.reverse();
            String string = stringBuilder.toString();

            if (res == null || res.compareTo(string) > 0) {
                res = string;
            }

            stringBuilder.reverse();
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            return;
        }

        traverse(root.left);
        traverse(root.right);

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }
}
