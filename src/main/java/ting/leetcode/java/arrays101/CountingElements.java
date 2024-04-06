package ting.leetcode.java.arrays101;

import java.util.HashMap;

public class CountingElements {
    public int countElements(int[] arr) {
        int ans = 0;
        HashMap<Integer, Integer> intToInt = new HashMap<>();
        for (int i : arr) {
            intToInt.merge(i, 1, Integer::sum);
        }

        for (int i : intToInt.keySet()) {
            if (intToInt.containsKey(i) && intToInt.containsKey(i + 1)) {
                ans += intToInt.get(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int i = new CountingElements().countElements(new int[]{1, 1, 2, 3});
        System.out.println(i);
    }
}
