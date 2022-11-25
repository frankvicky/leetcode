package ting.java.leetcode.hashtable;

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
}
