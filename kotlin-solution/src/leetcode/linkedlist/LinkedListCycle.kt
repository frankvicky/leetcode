package leetcode.linkedlist

class LinkedListCycle {
    fun hasCycle(head: leetcode.linkedlist.ListNode?): Boolean {
        var slowPointer = head
        var fastPointer = head

        while (slowPointer?.next != null) {
            slowPointer = slowPointer.next
            fastPointer = fastPointer?.next?.next ?: break
            if (slowPointer == fastPointer) return true
        }
        return false
    }
}

class ListNode(var `val`: Int) {
    var next: leetcode.linkedlist.ListNode? = null
}

