package ting.leetcode.recursion

import ting.leetcode.linkedlist.ListNode

class MergeTwoSortedLists {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val fullList = traversal(list1) + traversal(list2)
        val customHead = ListNode(0)
        var currentNodes: ListNode? = customHead
        fullList.sortedBy { it?.`val` }.forEach {
            currentNodes?.next = it
            currentNodes = currentNodes?.next
        }
        return customHead.next
    }

    fun traversal(node: ListNode?): List<ListNode?> {
        if (node == null) return emptyList()
        val result = mutableListOf<ListNode?>()
        result.add(node)
        result.addAll(traversal(node.next))
        return result
    }
}