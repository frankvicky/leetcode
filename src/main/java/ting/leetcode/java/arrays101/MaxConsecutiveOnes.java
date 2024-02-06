package ting.leetcode.java.arrays101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnesWithLinkedList(int[] nums) {
        final LinkedList<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toCollection(LinkedList::new));
        final ArrayList<Integer> indexes = new ArrayList<>();
        list.addFirst(0);
        list.addLast(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0)
                indexes.add(i);
        }
        int maxConsecutive = 0;
        for (int i = 0; i + 1 < indexes.size(); i++) {
            int currentConsecutive = indexes.get(i + 1) - indexes.get(i);
            if (currentConsecutive > maxConsecutive) {
                maxConsecutive = currentConsecutive;
            }
        }
        return maxConsecutive - 1;
    }
    
    public int findMaxConsecutiveOnes(int[] nums) {
        int consecutiveCount = 0;
        int maxConsecutiveCount = 0;
        for (int value : nums) {
            if (value == 1) {
                consecutiveCount++;
                maxConsecutiveCount = Math.max(consecutiveCount, maxConsecutiveCount);
            } else {
                consecutiveCount = 0;
            }
        }
        return maxConsecutiveCount;
    }
}
