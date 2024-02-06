package ting.leetcode.java.slidingwindow;

import java.util.*;

public class MinimumWindowSubstring {
    public static String minWindowBrutal(String s, String t) {
        if (s.length() < t.length())
            return "";

        if (s.equals(t))
            return t;

        int minWindowSize = t.length();
        Map<Character, Integer> charToCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            charToCount.merge(c, 0, (v1, v2) -> --v1 == 0 ? null : v1);
        }

        char[] sArray = s.toCharArray();


        int start = 0;
        int end = 0;
        int size = s.length();
        for (int i = 0; i <= sArray.length - minWindowSize; i++) {
            Map<Character, Integer> temp = new HashMap<>(charToCount);
            for (int j = i; j < sArray.length; j++) {
                char key = sArray[j];
                temp.computeIfPresent(key,  (character, count) -> --count == 0 ? null : count);
                if (temp.isEmpty() && j - i < size) {
                    start = i;
                    end = j + 1;
                    size = end - start;
                    break;
                }
            }
        }

        return String.valueOf(Arrays.copyOfRange(sArray, start, end));

    }

    public static String minWindow(String s, String t) {
        // 首先，我們檢查輸入是否有效。如果源字符串s的長度小於目標字符串t的長度，沒有合適的窗口可以包含t，因此我們返回一個空字符串
        if (s.length() < t.length())
            return "";
        // 如果源字符串s與目標字符串t完全相同，我們返回目標字符串
        if (s.equals(t))
            return t;

        // 根據目標字符串t中的字母種類和數量，創建一個大小為58的原始陣列
        int[] charFrequency = new int[58];
        // 使用Java的foreach語法遍歷目標字符串t的所有字母，根據ASCII碼轉化為0-57的範圍后，相應位置的字母次數加一
        for (char c : t.toCharArray()) {
            charFrequency[c - 'A']++;
        }

        // 定義兩個指針，開始（start）和結束（end）來追蹤源字符串s中當前被視為窗口的部分
        int start = 0, end = 0,
                // 已匹配字母數量
                matched = 0,
                // 初始化最小窗口大小為無限大
                minLen = Integer.MAX_VALUE,
                // 最小窗口的開始位置
                minStart = 0;

        // 當尚未查看源字符串s的所有字符時
        while (end < s.length()) {
            // 如果s中當前讀取到的字符在t中存在（由陣列idx得知），matched數量增加
            // 在陣列中將該字母索引位置的值減一，表示匹配到一個字母，該字母還需要的數量減少一個
            if (--charFrequency[s.charAt(end++) - 'A'] >= 0)
                matched++;

            // 如果目前已經匹配到的字母達到目標字符串的長度，則嘗試收縮窗口
            while (matched == t.length()) {
                // 如果目前窗口的長度小於至今找到的最小窗口，則更新最小窗口的信息，包括開始位置和長度
                if (end - start < minLen) {
                    minLen = end - start;
                    minStart = start;
                }

                // 將窗口開始位置的字母移出窗口，
                // 若該字母是必需的，則matched數量降低一個，並在陣列中對應位置索引的值增加一，表示這個字母還需要的數量增加一個
                if (++charFrequency[s.charAt(start++) - 'A'] > 0)
                    matched--;
            }
        }

        // 如果最小窗口長度仍然是無限大，表示源字符串s中不存在包含目標字符串t的所有字符的窗口，故返回空字符串
        // 否則，我們使用Java的substring函數從源字符串s中截取出最小窗口區域作為答案返回
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }




    public static void main(String[] args) {
        System.out.println(MinimumWindowSubstring.minWindowBrutal("ADOBECODEBANC", "ABC"));
//        System.out.println(MinimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(MinimumWindowSubstring.minWindow("cabwefgewcwaefgcf", "cae"));
    }
}
