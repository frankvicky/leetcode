package ting.leetcode.java.binarytree;

import java.util.HashMap;
import java.util.LinkedList;

public class PathSumIII {
    // 從根結點開始，路徑和為 pathSum 的路徑有 preSumCount.get(pathSum) 條
    private final HashMap<Long, Integer> preSumCount = new HashMap<>();

    long pathSum = 0;
    int res = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        preSumCount.put(0L, 1);
        traverse(root, targetSum);
        return res;
    }

    private void traverse(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }

        pathSum += root.val;
        res += preSumCount.getOrDefault(pathSum - targetSum, 0);
        preSumCount.put(pathSum, preSumCount.getOrDefault(pathSum, 0) + 1);

        traverse(root.left, targetSum);
        traverse(root.right, targetSum);
        preSumCount.put(pathSum, preSumCount.get(pathSum) - 1);
        pathSum -= root.val;
    }
}
