package ting.leetcode.java.linkedlist;

import org.jetbrains.annotations.Nullable;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode targetNextNode = findNthNodeFromEnd(dummyHead, n + 1);
        targetNextNode.next = targetNextNode.next.next;
        return dummyHead.next;
    }

    @Nullable
    private ListNode findNthNodeFromEnd(ListNode head, int n) {
        // 這個演算法的核心精髓就是間距的概念
        // 利用雙指針先拉出跟題目要求一模一樣的間距，然後同時移動兩根指針
        // 直到第一根指針達到尾端，第二根指針跟第一根指針的間距，就是尾部節點到達倒數第 n 個節點的距離。
        ListNode firstPointer = head;
        for (int i = 0; i < n; i++) {
            firstPointer = firstPointer.next;
        }

        ListNode secondPointer = head;
        while (firstPointer != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        return secondPointer;
    }
}
