package ting.leetcode.java.dynamicprogramming;

import java.util.Arrays;

public class CoinChange {
    int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 陣列大小為 amount + 1, 初始值也為 amount + 1
        Arrays.fill(dp, amount + 1);

        // base case
        dp[0] = 0;
        // 外層 for 在遍歷所有狀態的所有取值
        for (int i = 0; i < dp.length; i++) {
            // 內層 for 在求所有選擇的最小值
            for (int coin : coins) {
                // 子問題無解跳過
                // 以這題來說， i 代表的是子問題的 amount
                // 如果 coin 面額大於 i，自然無法找出需要多少硬幣剛好滿足 amount(i)
                if (i - coin < 0) {
                    continue;
                }
                // Math 第二個參數代表，上一個子問題的基礎上多一個 coin
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}

class Temp {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        //base case
        dp[0] = 0;

        // 當目標金額為 i 時，需要 dp[i] 個金幣才能湊出來
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.max(dp[i], 1 + dp[i - coin]);
            }
        }

        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}