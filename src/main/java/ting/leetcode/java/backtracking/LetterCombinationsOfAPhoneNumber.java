package ting.leetcode.java.backtracking;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    List<String> ans = new LinkedList<>();
    boolean[][] used;
    String[] digitToStr = {
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        used = new boolean[digits.length()][26];
        backtrack("", 0, digits.toCharArray());
        return ans;
    }

    private void backtrack(String string, int index, char[] digits) {
        if (string.length() == digits.length && !string.isEmpty()) {
            ans.add(string);
            return;
        }

        if (index >= digits.length) {
            return;
        }

        char[] chars = digitToStr[digits[index] - '2'].toCharArray();
        for (char c : chars) {
            if (used[index][c - 'a']) {
                continue;
            }
            String newStr = string + c;
            used[index][c - 'a'] = true;
            backtrack(newStr, index + 1, digits); // focus on the next digit
            used[index][c - 'a'] = false;
        }
    }
}
