package ting.leetcode.java.arrays101;

public class MaximumOddBinaryNumber {
    public String maximumOddBinaryNumber(String s) {
        char[] ans = s.toCharArray();
        int count = 0;
        for (char c : ans) {
            if (c == '1')
                count++;
        }

        ans[s.length() - 1] = '1';
        count--;
        for (int i = 0; i < ans.length - 1; i++) {
            if (count-- > 0)
                ans[i] = '1';
            else
                ans[i] = '0';
        }
        return String.valueOf(ans);
    }
}
