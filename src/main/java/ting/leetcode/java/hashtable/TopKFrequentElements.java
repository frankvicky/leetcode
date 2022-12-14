package ting.leetcode.java.hashtable;

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        var numsCount = new HashMap<Integer, Integer>();
        for (int currentNum : nums) {
            numsCount.putIfAbsent(currentNum, 0);
            numsCount.put(currentNum, numsCount.get(currentNum) + 1);
        }
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(numsCount.entrySet().stream().toList());
        entries.sort(Comparator.comparingInt(value -> -value.getValue()));
        var result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = entries.get(i).getKey();
        }
        return result;
    }
}
