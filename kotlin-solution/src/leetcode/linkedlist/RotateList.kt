package leetcode.linkedlist

class RotateList {
    fun rotateRight(head: leetcode.linkedlist.ListNode?, k: Int): leetcode.linkedlist.ListNode? {
        head?.next ?: return head
        var currentNode = head
        var length = 1
        while (currentNode != null) {
            currentNode = currentNode.next
            length++
            if (currentNode?.next == null) {
                currentNode?.next = head.also { currentNode = it }
                break
            }
        }

        val rotate = length - (k % length)
        for (i in 1 until rotate) currentNode = currentNode?.next

        return currentNode?.next.also { currentNode?.next = null }
    }
}
