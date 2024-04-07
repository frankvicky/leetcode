package ting.leetcode.java.hashtable;

public class CheckIfTheSentenceIsPangram {
    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) return false;
        int[] cache = new int[26];
        char[] chars = sentence.toCharArray();

        for (char c : chars) {
            cache[c - 'a']++;
        }

        for (int i : cache) {
            if ((i & 1) == 0) return false;
        }
        return true;
    }
}
