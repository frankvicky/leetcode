package ting.leetcode.java.linkedlist;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode current) {
        if (current == null || current.next == null) {
            return current;
        }

        // 透過遞迴找到最後一個節點，也就是反轉後的頭部節點
        ListNode last = reverseList(current.next);
        current.next.next = current;
        current.next = null;
        return last;
    }

    // 另一種反轉法，結就較為簡單
    public ListNode reverse(ListNode head, ListNode prev) {
        if (head == null) return prev;
        ListNode newHead = head.next;
        head.next = prev;
        return reverse(newHead, head);
    }

    public ListNode reverseListByLoop(ListNode current) {
        if (current == null) {
            return null;
        }

        ListNode prev = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
