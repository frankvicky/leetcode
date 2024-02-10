package ting.leetcode.java.linkedlist;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode firstPointer = headA;
        ListNode secondPointer = headB;

        while (firstPointer != secondPointer) {
            if (firstPointer == null)
                firstPointer = headB;
            else
                firstPointer = firstPointer.next;

            if (secondPointer == null)
                secondPointer = headA;
            else
                secondPointer = secondPointer.next;
        }

        return firstPointer;
    }
}
