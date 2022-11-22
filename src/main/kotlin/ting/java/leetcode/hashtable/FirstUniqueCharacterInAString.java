package ting.java.leetcode.hashtable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character, ArrayList<Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.putIfAbsent(chars[i], new ArrayList<>());
            map.get(chars[i]).add(i);
        }
        var resultList = map.values().stream().filter(integers -> integers.size() == 1).toList();
        return resultList.isEmpty()? -1 : resultList.get(0).get(0);
    }

    public int firstUniqCharWithInteger(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char aChar : chars) {
            map.putIfAbsent(aChar, 0);
            map.put(aChar, map.get(aChar) + 1);
        }
        var resultList = map.entrySet().stream().filter((entry) -> entry.getValue() == 1).map(Map.Entry::getKey).toList();
        return resultList.isEmpty() ? -1 : s.indexOf(resultList.get(0));
    }
}
