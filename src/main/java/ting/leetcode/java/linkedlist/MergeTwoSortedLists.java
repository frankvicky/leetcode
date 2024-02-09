package ting.leetcode.java.linkedlist;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode firstPointer = list1;
        ListNode secondPointer = list2;
        ListNode answer = new ListNode();
        ListNode current = answer;

        while (firstPointer != null && secondPointer != null) {
            if (firstPointer.val <= secondPointer.val) {
                current.next = firstPointer;
                firstPointer = firstPointer.next;
            } else {
                current.next = secondPointer;
                secondPointer = secondPointer.next;
            }

            current = current.next;
        }

        if (firstPointer != null)
            current.next = firstPointer;

        if (secondPointer != null)
            current.next = secondPointer;

        return answer.next;
    }

}
