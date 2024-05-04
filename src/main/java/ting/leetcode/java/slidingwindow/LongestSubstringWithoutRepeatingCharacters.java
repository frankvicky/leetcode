package ting.leetcode.java.slidingwindow;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        var currentStart = 0;
        var currentMax = 0;
        var map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            var currentChar = s.charAt(i);
            var lastIndex = map.get(currentChar);
            if (lastIndex != null && lastIndex >= currentStart) {
                currentMax = Math.max(i - currentStart, currentMax);
                currentStart = lastIndex + 1;
            }
            map.put(currentChar, i);
        }

        return Math.max(currentMax, s.length() - currentStart);
    }


    public int lengthOfLongestSubstring2(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        int answer = 0;
        int left = 0, right = 0;

        while (right < s.length()) {
            char in = s.charAt(right);
            right++;

            window.put(in, window.getOrDefault(in, 0) + 1);

            while (window.get(in) > 1) {
                char out = s.charAt(left);
                left++;
                window.put(out, window.get(out) - 1);
            }
            answer = Math.max(right - left, answer);
        }

        return answer;
    }
}
