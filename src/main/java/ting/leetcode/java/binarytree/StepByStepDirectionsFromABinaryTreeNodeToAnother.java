package ting.leetcode.java.binarytree;

public class StepByStepDirectionsFromABinaryTreeNodeToAnother {
    private int startValue;
    private int destValue;
    private String startPath;
    private String destPath;
    private final StringBuilder stringBuilder = new StringBuilder();

    public String getDirections(TreeNode root, int startValue, int destValue) {
        this.startValue = startValue;
        this.destValue = destValue;
        traverse(root);
        int p = 0, m = startPath.length(), n = destPath.length();
        while (p < m && p < n && startPath.charAt(p) == destPath.charAt(p))
            p++;
        startPath = startPath.substring(p);
        destPath = destPath.substring(p);
        startPath = "U".repeat(startPath.length());
        return startPath + destPath;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.val == startValue)
            startPath = stringBuilder.toString();
        if (root.val == destValue)
            destPath = stringBuilder.toString();

        stringBuilder.append('L');
        traverse(root.left);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append('R');
        traverse(root.right);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }
}
