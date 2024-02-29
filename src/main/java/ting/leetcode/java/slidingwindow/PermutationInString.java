package ting.leetcode.java.slidingwindow;

import java.util.HashMap;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char c : s1.toCharArray()) {
            need.merge(c, 1, (v1, v2) -> ++v1);
        }

        int left = 0, right = 0, count = 0;

        while (right < s2.length()) {
            char in = s2.charAt(right++);
            window.merge(in, 1, (v1, v2) -> ++v1);
            if (window.get(in).equals(need.get(in))) {
                count++;
            }

            while (right - left >= s1.length()) {
                if (count == need.size())
                    return true;
                char out = s2.charAt(left);
                left++;
                if (need.containsKey(out)) {
                    if (window.get(out).equals(need.get(out)))
                        count--;
                    window.put(out, window.getOrDefault(out, 0) - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new PermutationInString().checkInclusion("ab", "eidbaooo");
    }
}
