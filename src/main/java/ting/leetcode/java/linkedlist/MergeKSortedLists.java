package ting.leetcode.java.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode dummyHead = new ListNode();
        ListNode pointer = dummyHead;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        while (!queue.isEmpty()) {
            ListNode smallest = queue.poll();
            pointer.next = smallest;
            if (smallest.next != null) {
                queue.offer(smallest.next);
            }
            pointer = pointer.next;
        }

        return dummyHead.next;
    }
}
