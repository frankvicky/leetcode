package ting.leetcode.java.hashtable;

import java.util.*;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> resultList = new ArrayList<>();
        int[] intersectNums = Arrays.stream(nums1).filter(value1 -> Arrays.stream(nums2).anyMatch(value2 -> value1 == value2)).distinct().toArray();
        Map<Integer, Integer> map1 = createMap(nums1);
        Map<Integer, Integer> map2 = createMap(nums2);
        for (int value : intersectNums) {
            int occurrences = Math.min(map1.get(value), map2.get(value));
            for (int i = 0; i < occurrences ; i++) {
                resultList.add(value);
            }
        }
        return resultList.stream().mapToInt(v -> v).toArray();
    }
    private Map<Integer, Integer> createMap(int[] intArray) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : intArray) {
            map.putIfAbsent(value, 0);
            map.put(value, map.get(value) + 1);
        }
        return map;
    }
}
