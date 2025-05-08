package ting.leetcode.java.binarytree;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    private final List<Integer> res = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i < 10; i++) {
            traverse(i, n);
        }
        return res;
    }

    private void traverse(int root, int n) {
        if (root > n) {
            return;
        }

        res.add(root);
        for (int child = root * 10; child < root * 10 + 10; child++) {
            traverse(child, n);
        }
    }
}
