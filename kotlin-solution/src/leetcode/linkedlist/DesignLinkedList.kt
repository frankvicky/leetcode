package leetcode.linkedlist

class MyLinkedList() {
    private var head: leetcode.linkedlist.MyLinkedList.Node? = null

    class Node(value: Int) {
        var `val`: Int = value
        var next: leetcode.linkedlist.MyLinkedList.Node? = null
    }

    fun get(index: Int): Int = getNode(index)?.`val` ?: -1

    fun addAtHead(`val`: Int) {
        if (initHeadIfNull(`val`)) return

        this.head = leetcode.linkedlist.MyLinkedList.Node(`val`).also {
            it.next = this.head
        }
    }

    fun addAtTail(`val`: Int) {
        if (initHeadIfNull(`val`)) return

        var currentNode = head
        while (currentNode?.next != null) currentNode = currentNode.next!!
        currentNode?.next = leetcode.linkedlist.MyLinkedList.Node(`val`)
    }

    fun addAtIndex(index: Int, `val`: Int) {
        if (index == 0) {
            addAtHead(`val`)
            return
        }

        val currentNode = getNode(index - 1)
        currentNode?.next = leetcode.linkedlist.MyLinkedList.Node(`val`).also {
            it.next = currentNode?.next
        }

    }

    fun deleteAtIndex(index: Int) {
        if (index == 0) {
            head = head?.next
            return
        }
        val currentNode = getNode(index - 1)
        val targetNode = currentNode?.next
        currentNode?.next = targetNode?.next

    }

    private fun getNode(index: Int): leetcode.linkedlist.MyLinkedList.Node? {
        var index = index
        var currentNode = head
        while (index > 0) {
            currentNode = currentNode?.next ?: return null
            index--
        }
        return currentNode
    }

    private fun initHeadIfNull(`val`: Int): Boolean {
        val isHeadNull = head == null
        if (isHeadNull) head = leetcode.linkedlist.MyLinkedList.Node(`val`)
        return isHeadNull
    }

}

