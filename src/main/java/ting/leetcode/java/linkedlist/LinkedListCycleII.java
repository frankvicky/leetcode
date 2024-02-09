package ting.leetcode.java.linkedlist;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode firstPointer = head;
        ListNode secondPointer = head;

        while (firstPointer != null) {
            firstPointer = firstPointer.next;
            if (firstPointer != null) {
                firstPointer = firstPointer.next;
                secondPointer = secondPointer.next;
            }

            if (firstPointer == secondPointer) {
                secondPointer = head;
                while (firstPointer != secondPointer) {
                    firstPointer = firstPointer.next;
                    secondPointer = secondPointer.next;
                }
                return secondPointer;
            }
        }

        return null;
    }
}
