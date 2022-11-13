package ting.leetcode.linkedlist

class FlattenAMultilevelDoublyLinkedList {
    private var forkNodes = mutableListOf<Node>()
    var customHead = Node(0)
    var newListPointer = customHead
    private var counter = 0

    fun flatten(root: Node?): Node? {
        var currentNode: Node? = root
        while (currentNode != null) {
            createNewNode(currentNode.`val`)

            currentNode = when (currentNode.child) {
                null -> currentNode.next
                else -> {
                    forkNodes.add(0, currentNode)
                    currentNode.child
                }
            }
        }

        if (counter < forkNodes.size) flatten(forkNodes[counter++].next)

        return customHead.next?.apply { prev = null }
    }

    private fun createNewNode(value: Int): Unit {
        with(Node(value)) {
            newListPointer.next = this
            prev = newListPointer
            newListPointer = newListPointer.next!!
        }
    }
}


class Node(var `val`: Int) {
    var prev: Node? = null
    var next: Node? = null
    var child: Node? = null
}