package ting.leetcode.java.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (char c : p.toCharArray()) {
            need.merge(c, 1, (v1, v2) -> ++v1);
        }

        int left = 0, right = 0, count = 0;
        while (right < s.length()) {
            char in = s.charAt(right++);
            window.merge(in, 1, (v1, v2) -> ++v1);
            if (window.get(in).equals(need.get(in))) {
                count++;
            }

            while (right - left >= p.length()) {
                if (count == need.size()) {
                    ans.add(left);
                }
                char out = s.charAt(left++);
                if (need.containsKey(out)) {
                    if (window.get(out).equals(need.get(out))) {
                        count--;
                    }
                    window.put(out, window.get(out) - 1);
                }
            }
        }
        return ans;
    }
}
