package ting.leetcode.java.backtracking;

import java.util.LinkedList;
import java.util.List;


public class Subsets {
    private final List<List<Integer>> answer = new LinkedList<>();
    private final LinkedList<Integer> track = new LinkedList<>(); // 紀錄選擇

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return answer;
    }

    private void backtrack(int[] nums, int start) {
        answer.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }
}
