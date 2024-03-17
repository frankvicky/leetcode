package ting.leetcode.java.arrays101;

import java.util.ArrayList;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> answers = new ArrayList<>();
        int i = 0;

        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            answers.add(intervals[i++]);
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        answers.add(newInterval);

        while (i < intervals.length) {
            answers.add(intervals[i++]);
        }

        int[][] result = new int[answers.size()][2];
        for (int j = 0; j < result.length; j++) {
            result[j] = answers.get(j);
        }

        return result;
    }
}
