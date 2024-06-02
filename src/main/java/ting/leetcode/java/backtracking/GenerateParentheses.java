package ting.leetcode.java.backtracking;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
    private final List<String> ans = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return ans;
        }

        backtrack(n, n, new StringBuilder());
        return ans;
    }

    private void backtrack(int left, int right, StringBuilder track) {
        if (left > right) {
            return;
        }

        if (left < 0 || right < 0) {
            return;
        }

        if (left == 0 && right == 0) {
            ans.add(track.toString());
            return;
        }

        track.append('(');
        backtrack(left - 1, right, track);
        track.deleteCharAt(track.length() - 1);

        track.append(')');
        backtrack(left, right - 1, track);
        track.deleteCharAt(track.length() - 1);
    }
}
