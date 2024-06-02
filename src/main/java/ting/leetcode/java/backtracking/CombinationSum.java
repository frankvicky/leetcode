package ting.leetcode.java.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    private final List<List<Integer>> ans = new LinkedList<>();
    boolean[] used = new boolean[10];

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k, n, new ArrayList<>(k), 0, 1);
        return ans;
    }

    private void backtrack(int remaining, int n, List<Integer> elements, int prefixSum, int index) {
        if (remaining == 0 && prefixSum == n) {
            ans.add(new ArrayList<>(elements));
            return;
        }

        if (index > 9) {
            return;
        }

        for (int i = index; i < 10; i++) {
            if (used[i]) {
                continue;
            }

            if (prefixSum + i > n) {
                continue;
            }

            elements.add(i);
            used[i] = true;
            backtrack(remaining - 1, n, elements, prefixSum + i, index + 1);
            elements.remove(elements.size() - 1);
            used[i] = false;
        }
    }
}
