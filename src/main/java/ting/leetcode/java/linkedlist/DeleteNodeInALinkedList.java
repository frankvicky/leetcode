package ting.leetcode.java.linkedlist;

import java.util.Arrays;

public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        Arrays.sort(new int[] {1});
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
