package ting.leetcode.linkedlist

class MergeTwoSortedLists {

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val nodes = mutableListOf<ListNode?>()
        val customHead = ListNode(0)
        var currentNodes: ListNode? = customHead
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

    private fun addNodesToCollection(head: ListNode?, destination: MutableCollection<ListNode?>): Unit {
        var currentNodes = head
        while (currentNodes != null) {
            destination.add(currentNodes)
            currentNodes = currentNodes.next
        }
    }
}