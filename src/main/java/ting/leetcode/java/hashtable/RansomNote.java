package ting.leetcode.java.hashtable;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cache = new int[26];
        for (char c : ransomNote.toCharArray()) {
            cache[c - 'a']++;
        }

        for (char c : magazine.toCharArray()) {
            cache[c - 'a']--;
        }

        for (int i : cache) {
            if (i > 0) return false;
        }

        return true;
    }
}
