package ting.leetcode.java.linkedlist;

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode firstPinter = head;
        ListNode secondPointer = head;

        while (firstPinter != null) {
            firstPinter = firstPinter.next;
            if (firstPinter != null) {
                firstPinter = firstPinter.next;
                secondPointer = secondPointer.next;
            }
        }
        return secondPointer;
    }
}
