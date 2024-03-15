package leetcode.linkedlist

class RemoveLinkedListElements {
    fun removeElements(head: leetcode.linkedlist.ListNode?, value: Int): leetcode.linkedlist.ListNode? {
        if (head == null) return null
        val customHead = leetcode.linkedlist.ListNode(0)
        var secondListNode: leetcode.linkedlist.ListNode? = customHead
        var currentNode: leetcode.linkedlist.ListNode? = head

        while (currentNode != null) {
            if (currentNode.`val` != value) {
                secondListNode?.next = leetcode.linkedlist.ListNode(currentNode.`val`)
                secondListNode = secondListNode?.next
            }
            currentNode = currentNode.next
        }
        return customHead.next
    }

}
