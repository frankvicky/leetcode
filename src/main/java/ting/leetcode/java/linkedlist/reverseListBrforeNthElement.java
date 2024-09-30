package ting.leetcode.java.linkedlist;

public class reverseListBrforeNthElement {
    ListNode successor = null;

    ListNode reverseNRecursively(ListNode head, int n) {
        if (n == 1) {
            successor = head;
            return head;
        }

        ListNode last = reverseNRecursively(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    ListNode reverseN(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null, cur = head, nxt = head.next;

        while (n > 0) {
            cur.next = pre;
            pre = cur;
            cur = nxt;
            if (nxt != null) {
                nxt = nxt.next;
            }
            n--;
        }
        // 此时的 cur 是第 n + 1 个节点，head 是反转后的尾结点
        head.next = cur;

        // 此时的 pre 是反转后的头结点
        return pre;
    }
}
