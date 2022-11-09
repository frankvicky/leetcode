package ting.leetcode.linkedlist

class IntersectionOfTwoLinkedList {
    fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {
        val set = mutableSetOf<ListNode?>()
        var pointer = headA
        while (pointer != null && set.add(pointer)) pointer = pointer.next
        pointer = headB
        while (pointer != null && set.add(pointer)) pointer = pointer.next
        return pointer
    }
}