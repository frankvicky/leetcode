package ting.leetcode.java.binarytree;

import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return build(1, n);
    }

    private List<TreeNode> build(int low, int high) {
        LinkedList<TreeNode> res = new LinkedList<>();
        if (low > high) {
            // 这里需要装一个 null 元素，这样才能让下面的两个内层 for 循环都能进入，正确地创建出叶子节点
            // 举例来说吧，什么时候会进到这个 if 语句？当你创建叶子节点的时候，对吧。
            // 那么如果你这里不加 null，直接返回空列表，那么下面的内层两个 for 循环都无法进入
            // 你的那个叶子节点就没有创建出来，看到了吗？所以这里要加一个 null，确保下面能把叶子节点做出来
            res.add(null);
            return res;
        }

        for (int i = low; i <= high; i++) {
            List<TreeNode> leftNodes = build(low, i - 1);
            List<TreeNode> rightNodes = build(i + 1, high);
            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
