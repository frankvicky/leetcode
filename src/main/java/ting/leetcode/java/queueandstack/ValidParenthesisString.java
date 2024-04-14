package ting.leetcode.java.queueandstack;

import java.util.LinkedList;

public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        // 存放 ( 和 * 的索引
        LinkedList<Integer> leftBrackets = new LinkedList<>();
        LinkedList<Integer> stars = new LinkedList<>();

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                leftBrackets.push(i);
            } else if (c == '*') {
                stars.push(i);
            } else {
                if (!leftBrackets.isEmpty())
                    leftBrackets.pop();
                else if (!stars.isEmpty())
                    stars.pop();
                else return false;
            }
        }

        while (!leftBrackets.isEmpty() && !stars.isEmpty()) {
            // 如果 * 號在 ( 的左邊則無法配對
            if (leftBrackets.pop() > stars.pop())
                return false;
        }

        return leftBrackets.isEmpty();
    }
}
