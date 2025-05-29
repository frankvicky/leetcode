package ting.leetcode.java.binarytree;

import java.util.LinkedList;
import java.util.List;

public class AllPossibleFullBinaryTrees {
    private List<TreeNode>[] memo;
    public List<TreeNode> allPossibleFBT(int n) {
        if ((n & 1) == 0) {
            return List.of();
        }

        memo = new LinkedList[n + 1];
        return build(n);
    }

    private List<TreeNode> build(int n) {
        if (n == 1) {
            return List.of(new TreeNode(0));
        }

        LinkedList<TreeNode> res = new LinkedList<>();

        if (memo[n] != null) {
            return memo[n];
        }

        for (int i = 1; i < n; i += 2) {
            int j = n - i -1;
            List<TreeNode> leftSubTrees = build(i);
            List<TreeNode> rightSubTrees = build(j);

            for (TreeNode left : leftSubTrees) {
                for (TreeNode right : rightSubTrees) {
                    res.add(new TreeNode(0, left, right));
                }
            }
        }

        memo[n] = res;
        return res;
    }
}
