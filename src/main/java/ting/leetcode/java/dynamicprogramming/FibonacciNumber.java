package ting.leetcode.java.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {

    int fibDp(int n) {
        // 备忘录全初始化为 0
        int[] memo = new int[n + 1];
        // 进行带备忘录的递归
        return dp(memo, n);
    }

    // 带着备忘录进行递归
    int dp(int[] memo, int n) {
        // base case
        if (n == 0 || n == 1) return n;
        // 已经计算过，不用再计算了
        if (memo[n] != 0) return memo[n];
        memo[n] = dp(memo, n - 1) + dp(memo, n - 2);
        return memo[n];
    }


    public int fibButtonUp(int N) {
        if (N == 0) return 0;
        int[] dp = new int[N + 1];
        // base case
        dp[0] = 0; dp[1] = 1;
        // 状态转移
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[N];
    }

    public int fib(int n) {
        if (n == 0 || n == 1) return n;

        int prev = 0;
        int current = 1;
        int next = 0;
        for (int i = 2; i <= n; i++) {
            next = prev + current;
            prev = current;
            current = next;
        }
        return next;
    }
}
class Solution {

    final Map<Integer, Integer> numToAnswer = new HashMap<>();

    public int fib(int n) {
        if (n < 2)
            return n;

        if (numToAnswer.get(n) != null)
            return numToAnswer.get(n);

        numToAnswer.put(n, fib(n - 1) + fib(n - 2));
        return numToAnswer.get(n);
    }
}
