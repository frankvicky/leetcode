package ting.leetcode.beginnerguide

class MiddleOfTheLinkedList {
    fun middleNode(head: ListNode?): ListNode? {
//        var counter = 0
//        var currentNode = head
//        while (currentNode?.next != null) {
//            currentNode = currentNode.next
//            counter++
//        }
//        currentNode = head
//        println(counter)
//        val middleNodeCount = if (counter and 1 == 0) counter / 2 else counter / 2 + 1
//        for (i in 1..(middleNodeCount)) {
//            currentNode = currentNode?.next
//        }
//        return currentNode

//        middleNode will only move forward for 1 node once endNode move 2
        var middleNode = head
        var endNode = head;
        while (endNode?.next != null) {
            middleNode = middleNode?.next
            endNode = endNode.next?.next
        }

        return middleNode
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}