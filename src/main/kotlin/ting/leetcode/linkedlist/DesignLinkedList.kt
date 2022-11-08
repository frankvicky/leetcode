package ting.leetcode.linkedlist

class MyLinkedList() {
    private var head: Node? = null

    class Node(value: Int) {
        var `val`: Int = value
        var next: Node? = null
    }

    fun get(index: Int): Int {
        val currentNode = getNode(index)
        return currentNode?.`val` ?: -1
    }

    fun addAtHead(`val`: Int) {
        if (head == null) {
            head = Node(`val`)
            return
        }

        this.head = Node(`val`).also {
            it.next = this.head
        }
    }

    fun addAtTail(`val`: Int) {
        if (head == null) {
            head = Node(`val`)
            return
        }

        var currentNode = head
        while (currentNode?.next != null) currentNode = currentNode.next!!
        currentNode?.next = Node(`val`)
    }

    fun addAtIndex(index: Int, `val`: Int) {
        if (index == 0) {
            addAtHead(`val`)
            return
        }

        val currentNode = getNode(index - 1)
        currentNode?.next = Node(`val`).also {
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

    private fun getNode(index: Int): Node? {
        var index = index
        var currentNode = head
        while (index > 0) {
            currentNode = currentNode?.next ?: return null
            index--
        }
        return currentNode
    }

}

