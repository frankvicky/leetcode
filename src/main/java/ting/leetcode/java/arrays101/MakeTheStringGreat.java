package ting.leetcode.java.arrays101;

import java.util.LinkedList;

public class MakeTheStringGreat {
    public String makeGood(String s) {
        char[] chars = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        int i = 0;

        while (i < chars.length) {
            if (stack.isEmpty()) {
                stack.push(chars[i]);
                i++;
                continue;
            }

            char peek = stack.peek();
            if (Character.toUpperCase(peek) != Character.toUpperCase(chars[i])) {
                stack.push(chars[i]);
                i++;
                continue;
            }

            if (peek == chars[i]) {
                stack.push(chars[i]);
                i++;
                continue;
            }

            stack.pop();
            i++;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pollLast());
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LinkedList<String> strings = new LinkedList<>();
        strings.push("1");
        strings.push("2");
        strings.push("3");
        strings.offer("4");
        strings.peek();
    }
}
