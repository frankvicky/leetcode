package ting.leetcode.linkedlist

class RemoveLinkedListElements {
    fun removeElements(head: ListNode?, value: Int): ListNode? {
        if (head == null) return null
        val customHead = ListNode(0)
        var secondListNode: ListNode? = customHead
        var currentNode: ListNode? = head

        while (currentNode != null) {
            if (currentNode.`val` != value) {
                secondListNode?.next = ListNode(currentNode.`val`)
                secondListNode = secondListNode?.next
            }
            currentNode = currentNode.next
        }
        return customHead.next
    }

}