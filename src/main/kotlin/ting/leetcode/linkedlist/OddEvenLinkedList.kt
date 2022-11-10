package ting.leetcode.linkedlist

class OddEvenLinkedList {
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        val customOddHead = ListNode(0)
        val customEvenHead = ListNode(0)
        var oddNode: ListNode? = customOddHead
        var evenNode: ListNode? = customEvenHead
        var currentNode = head
        var count = 1
        while (currentNode != null) {
            if (count and 1 == 1) {
                oddNode?.next = ListNode(currentNode.`val`)
                oddNode = oddNode?.next
            } else {
                evenNode?.next = ListNode(currentNode.`val`)
                evenNode = evenNode?.next
            }
            currentNode = currentNode.next
            count++
        }
        oddNode?.next = customEvenHead?.next
        return customOddHead.next
    }

}