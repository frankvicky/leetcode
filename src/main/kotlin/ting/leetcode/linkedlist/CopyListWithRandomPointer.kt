package ting.leetcode.linkedlist

class CopyListWithRandomPointer {
    fun copyRandomList(node: RandomNode?): RandomNode? {
        val originalNodes = mutableListOf<RandomNode?>()
        val newNodes = mutableListOf<RandomNode?>()
        val customHead = RandomNode(0)
        var newListNodePointer: RandomNode = customHead
        var currentNode = node

        while (currentNode != null) {
            newListNodePointer = RandomNode(currentNode.`val`).also { newListNodePointer.next = it }
            originalNodes.add(currentNode)
            newNodes.add(newListNodePointer)
            currentNode = currentNode.next
        }
        originalNodes.forEachIndexed { index, node ->
            val randomIndex = originalNodes.indexOf(node?.random)
            if (randomIndex != -1) newNodes[index]?.random = newNodes[randomIndex]
        }

        return customHead.next
    }
}

class RandomNode(var `val`: Int) {
    // todo: rename class
    var next: RandomNode? = null
    var random: RandomNode? = null
}
