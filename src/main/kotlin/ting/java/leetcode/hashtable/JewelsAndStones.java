package ting.java.leetcode.hashtable;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        var list = stones.chars().mapToObj(c -> (char) c).toList();
        Map<Character, Long> map = list.stream().collect(groupingBy(Function.identity(), Collectors.counting()));
        var result = 0L;
        for (char c : jewels.toCharArray()) {
            result += map.getOrDefault(c, 0L);
        }
        return (int) result;
    }

    public int numJewelsInStonesWithList(String jewels, String stones) {
        var jewelsList = jewels.chars().mapToObj(c -> (char) c).toList();
        var result = 0;
        for (int i = 0; i < stones.length(); i++) {
            result = jewelsList.contains(stones.charAt(i)) ? result + 1 : result;
        }
        return result;
    }
}
