package ting.leetcode.java.arrays101;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((v1, v2) -> v2 - v1);

        int i = 0;
        int diff = 0;

        for (; i < heights.length - 1; i++) {
            diff = heights[i + 1] - heights[i];
            if (diff <= 0)
                continue;

            bricks -= diff;
            queue.offer(diff);

            if (bricks < 0) {
                // 如果磚塊用完了，就把前面最高的地方改為用梯子
                bricks += queue.poll();
                ladders--;
            }

            if (ladders < 0)
                break;
        }
        return i;
    }

}
