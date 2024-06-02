package ting.leetcode.java.arrays101;

public class ScoreOfString {
    public int scoreOfString(String s) {
        int ans = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            int current = chars[i];
            int next = chars[i + 1];
            ans += Math.abs(current - next);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new ScoreOfString().scoreOfString("hello"));
    }
}
