package ting.leetcode.java.linkedlist;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode current) {
        if (current == null || current.next == null) {
            return current;
        }

        ListNode nextNode = reverseList(current.next);
        current.next.next = current;
        current.next = null;
        return nextNode;
    }
}
