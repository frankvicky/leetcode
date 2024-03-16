package leetcode.recursion

import leetcode.linkedlist.ListNode

class ReverseLinkedList {
    var last: ListNode? = null
    fun reverseList(head: ListNode?): ListNode? =
        with(head) {
            reverse(this)
            last
        }

    fun reverse(node: ListNode?): Unit {
        if (node?.next == null) {
            last = node
            return
        }
        var currentNode = node
        reverse(currentNode.next)
        currentNode = currentNode.next.also {
            currentNode?.next = it?.next
            it?.next = currentNode
        }
    }
}
