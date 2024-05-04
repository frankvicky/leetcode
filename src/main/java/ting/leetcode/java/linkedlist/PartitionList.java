package ting.leetcode.java.linkedlist;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead1 = new ListNode();
        ListNode firstPointer = dummyHead1;
        ListNode dummyHead2 = new ListNode();
        ListNode secondPointer = dummyHead2;

        ListNode current = head;

        while (current != null) {
            if (current.val < x) {
                firstPointer.next = current;
                firstPointer = firstPointer.next;
            } else {
                secondPointer.next = current;
                secondPointer = secondPointer.next;
            }

            // 如果我們需要把原鏈表的節點接到新鏈表上，而不是 new 新節點來組成新鏈表的話，那麽斷開節點和原鏈表之間的鏈接可能是必要的。
            // 那其實我們可以養成一個好習慣，但凡遇到這種情況，就把原鏈表的節點斷開，這樣就不會出錯了。
            ListNode temp = current.next;
            current.next = null;
            current = temp;
        }

        firstPointer.next = dummyHead2.next;

        return dummyHead1.next;
    }
}

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode();
        ListNode p1 = dummy1;
        ListNode dummy2 = new ListNode();
        ListNode p2 = dummy2;
        ListNode current = head;

        while (current != null) {
            if (current.val < x) {
                p1.next = current;
                p1 = p1.next;
            } else {
                p2.next = current;
                p2 = p2.next;
            }

            ListNode temp = current.next;
            current.next = null;
            current = temp;
        }

        p1.next = dummy2.next;
        return dummy1.next;
    }
}