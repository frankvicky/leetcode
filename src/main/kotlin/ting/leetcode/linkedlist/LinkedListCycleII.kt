package ting.leetcode.linkedlist

class LinkedListCycleII {
    fun detectCycle(head: ListNode?): ListNode? {
        var slowPointer = head
        var fastPointer = head
        var catchUpPointer = head

        do {
            slowPointer = slowPointer?.next
            fastPointer = fastPointer?.next?.next ?: break
        } while (slowPointer != fastPointer)

        if (fastPointer == null) return null

        while (catchUpPointer != slowPointer) {
            catchUpPointer = catchUpPointer?.next
            slowPointer = slowPointer?.next
        }
        return catchUpPointer
    }

    fun detectCycleWithSet(head: ListNode?): ListNode? {
        var slowPointer = head
        var fastPointer = head
        var catchUpNode: ListNode? = null
        val elements = mutableSetOf<ListNode?>()
        var count = 0
        var catchUpPoint = 0
        while (elements.add(slowPointer)) {
            slowPointer = slowPointer?.next
            fastPointer = fastPointer?.next?.next ?: break
            count++
            if (slowPointer == fastPointer) {
                catchUpPoint = count
                catchUpNode = slowPointer
            }
        }

        if (catchUpNode == head) return head
        if (catchUpPoint != 0) {
            val targetIndex = elements.size % catchUpPoint
            for (i in 1..targetIndex) {
                catchUpNode = catchUpNode?.next
            }
            return catchUpNode
        }

        return null
    }
}

//fun detectCycle(head: ListNode?): ListNode? {
//    var slowPointer = head
//    var fastPointer = head
//
//    while (slowPointer?.next != null) {
//        slowPointer = slowPointer.next
//        fastPointer = fastPointer?.next?.next ?: break
//        if (slowPointer == fastPointer && slowPointer == head) return head
//        if (slowPointer == fastPointer && slowPointer != head) return slowPointer.next
//
//    }
//    return null
//}