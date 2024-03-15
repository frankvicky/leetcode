package leetcode.linkedlist

class ReverseLinkedList {
    fun reverseList(head: leetcode.linkedlist.ListNode?): leetcode.linkedlist.ListNode? {
        if (head?.next == null) return head
        val nodes = mutableListOf<leetcode.linkedlist.ListNode?>()
        var currentNode = head
        while (currentNode != null && nodes.add(currentNode))
            currentNode = currentNode.next.also { currentNode?.next = null }

        nodes.reverse()
        nodes.forEachIndexed { index, node ->
            if (index + 1 <= nodes.lastIndex) node?.next = nodes[index + 1]
        }

        return nodes.first()
    }

    // 反轉 link 方向，第一個 link 指向 null
    fun reverseListByReversingLink(head: leetcode.linkedlist.ListNode?): leetcode.linkedlist.ListNode? {
        var currentNode = head
        var reverseNode: leetcode.linkedlist.ListNode? = null

        while (currentNode != null) {
            reverseNode = leetcode.linkedlist.ListNode(currentNode.`val`).also { it.next = reverseNode }
            currentNode = currentNode.next
        }

        return reverseNode
    }
}
