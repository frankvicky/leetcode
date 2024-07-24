package ting.leetcode.java.arrays101;

import java.util.HashMap;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] cache = new int[101];
        int[] correct = new int[heights.length];
        int result = 0;
        for (int height : heights) {
            cache[height]++;
        }
        int index = 0;
        for (int i = 0; i < cache.length; i++) {
            int j = cache[i];
            while (j != 0) {
                correct[index++] = i;
                j--;
            }
        }
        for (int i = 0; i < correct.length; i++) {
            if (correct[i] != heights[i])
                result++;
        }
        return result;
    }

    public static void main(String[] args) {
        HashMap<Integer, Element> map = new HashMap<>();
        map.put(1, new Element(1, "1"));
        HashMap<Integer, Element> map2 = new HashMap<>(map);
        map2.put(1, new Element(2, "2"));
        map2.put(3, new Element(3, "3"));

        map.forEach((k, v) -> System.out.println(k + " : " + v));
        System.out.println("end");
        map2.forEach((k, v) -> System.out.println(k + " : " + v));
    }
    public record Element(
            Integer value,
            String name
    ){}
}
