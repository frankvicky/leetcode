package ting.leetcode.java.linkedlist;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode firstPointer = head;
        ListNode secondPointer = head;

        while (firstPointer != null) {
            firstPointer = firstPointer.next;
            if (firstPointer != null) {
                firstPointer = firstPointer.next;
                secondPointer = secondPointer.next;
            }

            if (firstPointer == secondPointer) {
                return true;
            }
        }

        return false;
    }
}
