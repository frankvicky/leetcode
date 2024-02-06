package ting.leetcode.java.arrays101;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> charToInt = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            charToInt.putIfAbsent(key, 0);
            charToInt.computeIfPresent(key, (character, integer) -> integer + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            charToInt.computeIfPresent(t.charAt(i), (character, integer) -> integer - 1);
        }

        for (int value : charToInt.values()) {
            if (value != 0)
                return false;
        }

        return true;
    }

    public boolean isAnagramSort(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);
    }
}
