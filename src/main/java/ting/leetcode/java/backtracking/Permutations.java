package ting.leetcode.java.backtracking;

import java.util.LinkedList;
import java.util.List;

public class Permutations {
    List<List<Integer>> answer = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        // 紀錄每次排列
        LinkedList<Integer> track = new LinkedList<>();
        // 記錄 nums 陣列中，哪些索引的數字已經被使用
        boolean[] used = new boolean[nums.length];

        backtrack(nums, track, used);
        return answer;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        // 結束條件
        if (track.size() == nums.length) {
            answer.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            track.add(nums[i]);
            used[i] = true;
            backtrack(nums, track, used);
            track.removeLast();
            used[i] = false;
        }
    }
}
