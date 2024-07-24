package ting.leetcode.java.arrays101;

import java.util.HashMap;

public class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> modToCount = new HashMap<>();
        modToCount.put(0, 1); // 初始值設置

        int prefixSum = 0;
        int result = 0;

        for (int num : nums) {
            prefixSum += num;
            int prefixSumMod = ((prefixSum % k) + k) % k; // 確保模數為非負數

            if (modToCount.containsKey(prefixSumMod)) {
                result += modToCount.get(prefixSumMod); // 累加符合條件的子數組數量
            }

            modToCount.put(prefixSumMod, modToCount.getOrDefault(prefixSumMod, 0) + 1); // 更新哈希表
        }

        return result;
    }

}
