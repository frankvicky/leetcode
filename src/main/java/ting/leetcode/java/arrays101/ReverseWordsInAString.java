package ting.leetcode.java.arrays101;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String reversed = reverseString(s);
        String[] wordArr = reversed.split(" ");
        String ans = "";
        for (String string : wordArr) {
            if (string.isEmpty()) continue;
            ans = ans.concat(reverseString(string)).concat(" ");
        }
        return ans.trim();
    }

    private String reverseString(String s) {
        char[] strArr = s.toCharArray();
        int mid = s.length() / 2;
        int lastIndex = s.length() - 1;
        for (int i = 0; i < mid; i++) {
            char temp = strArr[i];
            strArr[i] = strArr[lastIndex - i];
            strArr[lastIndex - i] = temp;
        }
        return String.valueOf(strArr);
    }
}
