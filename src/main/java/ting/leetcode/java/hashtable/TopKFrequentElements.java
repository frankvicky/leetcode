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

        entries.sort(Comparator.comparingInt(entry -> -entry.getValue()));
        var result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = entries.get(i).getKey();
        }
        return result;
    }


    public int[] topKFrequentAnother(int[] nums, int k) {
        Map<Integer, Integer> numToCount = new HashMap<>();

        for (int num : nums) {
            numToCount.putIfAbsent(num, 0);
            numToCount.computeIfPresent(num, (key, value) -> value + 1);
        }

        List<Integer> keys = numToCount.entrySet()
                .stream()
//                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(integer -> -1 * integer)))
                .map(Map.Entry::getKey)
                .toList();

        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            result[i] = keys.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] i = {1, 1, 1, 2, 2, 3};
        new TopKFrequentElements().topKFrequent(i, 2);
    }
}
