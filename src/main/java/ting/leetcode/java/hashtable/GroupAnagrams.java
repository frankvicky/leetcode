package ting.leetcode.java.hashtable;

import java.util.*;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.groupingBy;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strArray) {
        return new ArrayList<>(stream(strArray)
                .collect(groupingBy(this::sortString))
                .values());
    }

    private String sortString(String str) {
        var charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
