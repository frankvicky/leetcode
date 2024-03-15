package leetcode.linkedlist

class MergeTwoSortedLists {

    fun mergeTwoLists(list1: leetcode.linkedlist.ListNode?, list2: leetcode.linkedlist.ListNode?): leetcode.linkedlist.ListNode? {
        val nodes = mutableListOf<leetcode.linkedlist.ListNode?>()
        val customHead = leetcode.linkedlist.ListNode(0)
        var currentNodes: leetcode.linkedlist.ListNode? = customHead
        addNodesToCollection(list1, nodes)
        addNodesToCollection(list2, nodes)

        nodes.sortBy { it?.`val` }
        currentNodes = customHead
        nodes.forEach {
            currentNodes?.next = it
            currentNodes = currentNodes?.next
        }
        return customHead.next
    }

    private fun addNodesToCollection(head: leetcode.linkedlist.ListNode?, destination: MutableCollection<leetcode.linkedlist.ListNode?>): Unit {
        var currentNodes = head
        while (currentNodes != null) {
            destination.add(currentNodes)
            currentNodes = currentNodes.next
        }
    }

    fun mergeTwoListsWithTwoPointer(list1: leetcode.linkedlist.ListNode?, list2: leetcode.linkedlist.ListNode?): leetcode.linkedlist.ListNode? {
        val customHead = leetcode.linkedlist.ListNode(0)
        var currentNode: leetcode.linkedlist.ListNode? = customHead
        var node1 = list1
        var node2 = list2

        while (node1 != null && node2 != null) {
            if (node1.`val` > node2.`val`)
                currentNode = currentNode.let {
                    it?.next = node2
                    node2 = node2?.next
                    it?.next
                }
            else
                currentNode = currentNode.let {
                    it?.next = node1
                    node1 = node1?.next
                    it?.next
                }
        }

        if (node1 != null) currentNode?.next = node1
        if (node2 != null) currentNode?.next = node2

        return customHead.next
    }
}
