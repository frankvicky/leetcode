package ting.leetcode.java.hashtable;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (map.containsKey(value)) {
                result[0] = map.get(value);
                result[1] = i;
                break;
            }
            map.put(target - value, i);
        }
        return result;
    }
}
