package ting.leetcode.java.arrays101;

public class CustomSortString {
    public String customSortString(String order, String s) {
        int[] cache = new int[128];
        StringBuilder sb = new StringBuilder();
        char[] sArray = s.toCharArray();
        for (char c : sArray) {
            cache[c]++;
        }

        for (char c : order.toCharArray()) {
            while (cache[c] > 0) {
                cache[c]--;
                sb.append(c);
            }
        }

        for (char c : sArray) {
            while (cache[c] > 0) {
                cache[c]--;
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
