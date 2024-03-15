package leetcode.linkedlist

class OddEvenLinkedList {
    fun oddEvenList(head: leetcode.linkedlist.ListNode?): leetcode.linkedlist.ListNode? {
        if (head?.next == null) return head
        val customOddHead = leetcode.linkedlist.ListNode(0)
        val customEvenHead = leetcode.linkedlist.ListNode(0)
        var oddNode: leetcode.linkedlist.ListNode? = customOddHead
        var evenNode: leetcode.linkedlist.ListNode? = customEvenHead
        var currentNode = head
        var count = 1
        while (currentNode != null) {
            if (count and 1 == 1) {
                oddNode?.next = leetcode.linkedlist.ListNode(currentNode.`val`)
                oddNode = oddNode?.next
            } else {
                evenNode?.next = leetcode.linkedlist.ListNode(currentNode.`val`)
                evenNode = evenNode?.next
            }
            currentNode = currentNode.next
            count++
        }
        oddNode?.next = customEvenHead?.next
        return customOddHead.next
    }

}
