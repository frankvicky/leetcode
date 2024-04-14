package ting.leetcode.java.binarytree;

import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    // 此方法是用來生成所有唯一的二叉搜索樹的主方法
    public List<TreeNode> generateTrees(int n) {
        // 當森林中沒有樹時（也就是 n 為 0），則返回一個空的列表
        if (n == 0) {
            return new LinkedList<>();
        }
        // 呼叫構建功能以生成所有唯一的二元搜索樹
        return build(1, n);
    }
    // 此方法是用來逐層構建所有唯一的二元搜尋樹
    private List<TreeNode> build(int low, int high) {
        // 創建一個鏈接列表來儲存所有唯一的樹
        LinkedList<TreeNode> answer = new LinkedList<>();
        // 基本情況，如果低点大於高點，然後添加 null 到答案列表並返回
        if (low > high) {
            answer.add(null);
            return answer;
        }

        // 遍歷每一個節點，嘗試將其作為樹的根節點
        for (int i = low; i <= high; i++) {
            // 以 i 為根節點，所有可能的左子樹組合
            List<TreeNode> leftTree = build(low, i - 1);
            // 以 i 為根節點，所有可能的右子樹組合
            List<TreeNode> rightTree = build(i + 1, high);
            // 然後遍歷所有的左右子樹組合，並加入回答列表
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    answer.add(new TreeNode(i, left, right));
                }
            }
        }
        // 最後返回答案列表（包含所有唯一的二元搜索樹）
        return answer;
    }
}

