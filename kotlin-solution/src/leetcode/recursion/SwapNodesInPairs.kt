package leetcode.recursion

import leetcode.linkedlist.ListNode

class SwapNodesInPairs {
    fun swapPairs(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        var currentNode = head

        currentNode = currentNode.next.also {
            currentNode?.next = it?.next
            it?.next = currentNode
        }

        currentNode?.next?.next = swapPairs(currentNode?.next?.next)
        return currentNode
    }
}
