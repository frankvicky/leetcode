package leetcode.linkedlist

class FlattenAMultilevelDoublyLinkedList {
    private var forkNodes = mutableListOf<leetcode.linkedlist.Node>()
    private var customHead = leetcode.linkedlist.Node(0)
    private var newListPointer = customHead
    private var counter = 0

    fun flatten(root: leetcode.linkedlist.Node?): leetcode.linkedlist.Node? {
        var currentNode: leetcode.linkedlist.Node? = root
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
        with(leetcode.linkedlist.Node(value)) {
            newListPointer.next = this
            prev = newListPointer
            newListPointer = newListPointer.next!!
        }
    }
}


class Node(var `val`: Int) {
    var prev: leetcode.linkedlist.Node? = null
    var next: leetcode.linkedlist.Node? = null
    var child: leetcode.linkedlist.Node? = null
}
