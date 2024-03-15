package leetcode.linkedlist

class RemoveNthNodeFromEndOfList {
    fun removeNthFromEnd(head: leetcode.linkedlist.ListNode?, n: Int): leetcode.linkedlist.ListNode? {
        var head = head
        if (head?.next == null) return null
        var slowPointer = head
        var fastPointer = head
        var count = 1
        while (fastPointer?.next != null) {
            fastPointer = fastPointer.next
            count++
            if (count > n && fastPointer?.next != null) {
                slowPointer = slowPointer?.next
            }
        }
        if (count == n) {
            head = slowPointer?.next
            return head
        }

        val nextToTargetNode = slowPointer?.next?.next
        slowPointer?.next = nextToTargetNode

        return head
    }


    fun removeNthFromEndNew(head: leetcode.linkedlist.ListNode?, n: Int): leetcode.linkedlist.ListNode? {
        val dummyHead = leetcode.linkedlist.ListNode(0)
        dummyHead.next = head
        val targetPreviousNode = findNthFromEnd(dummyHead, n + 1)
        targetPreviousNode.next = targetPreviousNode.next!!.next
        return dummyHead.next
    }

    fun findNthFromEnd(head: leetcode.linkedlist.ListNode, n: Int): leetcode.linkedlist.ListNode {
        var fast: leetcode.linkedlist.ListNode? = head
        var slow: leetcode.linkedlist.ListNode? = head

        for (i in 0 until n) {
            fast = fast!!.next
        }

        while (fast != null) {
            fast = fast.next
            slow = slow!!.next
        }

        return slow!!
    }
}
