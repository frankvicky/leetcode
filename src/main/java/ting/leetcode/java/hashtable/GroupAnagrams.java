package ting.leetcode.java.hashtable;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class GroupAnagrams {
    public List<List<String>> groupAnagramsDirective(String[] strs) {
        List<char[]> charArrays = Arrays.stream(strs).map(String::toCharArray).toList();
        charArrays.forEach(Arrays::sort);

        HashMap<String, List<Integer>> strToIndex = new HashMap<>();

        for (int i = 0; i < charArrays.size(); i++) {
            String str = String.valueOf(charArrays.get(i));
            strToIndex.putIfAbsent(str, new ArrayList<>());
            int index = i;
            strToIndex.computeIfPresent(str, (s, integers) -> {
                integers.add(index);
                return integers;
            });
        }

        List<List<String>> result = new ArrayList<>();
        List<String> keys = new ArrayList<>(strToIndex.keySet());

        for (int i = 0; i < strToIndex.size(); i++) {
            result.add(new ArrayList<>());
            String key = keys.get(i);
            for (int index : strToIndex.get(key)) {
                result.get(i).add(strs[index]);
            }
        }

        return result;
    }

    public List<List<String>> groupAnagramsMap(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = String.valueOf(chars);

            map.putIfAbsent(sortedWord, new ArrayList<>());
            map.get(sortedWord).add(word);
        }

        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Collection<List<String>> list = Stream.of(strs)
                .collect(groupingBy(this::sortString))
                .values();
        return new ArrayList<>(list);
    }

    private String sortString(String str) {
        var charArray = str.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }
}
