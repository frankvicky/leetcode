package leetcode.linkedlist

class IntersectionOfTwoLinkedList {
    fun getIntersectionNode(headA: leetcode.linkedlist.ListNode?, headB: leetcode.linkedlist.ListNode?): leetcode.linkedlist.ListNode? {
        val set = mutableSetOf<leetcode.linkedlist.ListNode?>()
        var pointer = headA
        while (pointer != null && set.add(pointer)) pointer = pointer.next
        pointer = headB
        while (pointer != null && set.add(pointer)) pointer = pointer.next
        return pointer
    }
}
