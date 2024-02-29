package ting.leetcode.java.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
                temp.computeIfPresent(key, (character, count) -> --count == 0 ? null : count);
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


// 注意：java 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码不保证正确性，仅供参考。如有疑惑，可以参照我写的 cpp 代码对比查看。

    /**
     * 求字符串 s 中包含字符串 t 所有字符的最小子串
     *
     * @param s 源字符串
     * @param t 给定字符串
     * @return 满足条件的最小子串
     */
    public String minWindow2(String s, String t) {
        // 用于记录需要的字符和窗口中的字符及其出现的次数
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        // 统计 t 中各字符出现次数
        for (char c : t.toCharArray())
            need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0, right = 0;
        int valid = 0; // 窗口中满足需要的字符个数
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 扩大窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++; // 只有当 window[c] 和 need[c] 对应的出现次数一致时，才能满足条件，valid 才能 +1
            }

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 缩小窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--; // 只有当 window[d] 内的出现次数和 need[d] 相等时，才能 -1
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ?
                "" : s.substring(start, start + len);
    }

    public String minWindow3(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.merge(c, 1, (v1, v2) -> ++v1);
        }

        int left = 0;
        int right = 0;
        int count = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        while (right < s.length()) {
            char in = s.charAt(right);
            right++;

            window.merge(in, 1, (v1, v2) -> ++v1);
            if (window.get(in).equals(need.get(in))) {
                count++;
            }

            while (need.size() == count) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char out = s.charAt(left);
                left++;
                if (window.containsKey(out)) {
                    if (window.get(out).equals(need.get(out))) {
                        count--;
                    }
                    window.put(out, window.get(out) - 1);
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }


    public static void main(String[] args) {
        System.out.println(MinimumWindowSubstring.minWindowBrutal("ADOBECODEBANC", "ABC"));
//        System.out.println(MinimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(MinimumWindowSubstring.minWindow("cabwefgewcwaefgcf", "cae"));
    }
}
