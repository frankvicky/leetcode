package ting.leetcode.java.arrays101;

public class ReversePrefixOfWord {
    public String reversePrefix(String word, char ch) {
        char[] chars = word.toCharArray();
        int start = 0;
        int end = -1;
        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];
            if (current == ch) {
                end = i;
                break;
            }
        }

        if (end == -1)
            return word;

        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }

        return String.valueOf(chars);
    }
}
