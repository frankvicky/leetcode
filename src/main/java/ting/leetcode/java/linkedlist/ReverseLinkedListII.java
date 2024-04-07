package ting.leetcode.java.linkedlist;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        // move to left - 1 position
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        ListNode current = prev.next;
        // start reversing
        for (int i = 0; i < right - left; i++) {
            ListNode next = current.next;
            current.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummy.next;
    }
}
//在此例中，current 將始終指向節點2。在每次迴圈中，我們都把 current.next（即 next）"提前" 到反轉部分的首部。
// prev 指向反轉部分之前的一個節點（這裡是節點 1）。
//可以參考下列的操作順序：
//(before) 1 -> 2 -> 3 -> 4 -> 5
//(第一次迴圈后) 1 -> 3 -> 2 -> 4 -> 5
// (第二次迴圈后) 1 -> 4 -> 3 -> 2 -> 5