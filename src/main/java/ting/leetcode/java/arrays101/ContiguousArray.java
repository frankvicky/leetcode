package ting.leetcode.java.arrays101;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> sumToIndex = new HashMap<>();
        int current = 0;
        int answer = 0;

        sumToIndex.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                current--;
            } else {
                current++;
            }

            if (!sumToIndex.containsKey(current)) {
                sumToIndex.put(current, i);
            } else {
                answer = Math.max(answer, i - sumToIndex.get(current));
            }
        }

        return answer;
    }

    public static void main(String[] args) {
//        new ContiguousArray().findMaxLength(new int[] {0, 1, 0});
        new ContiguousArray().findMaxLength(new int[]{0,1,1,0,1,1,1,0});
    }
}
