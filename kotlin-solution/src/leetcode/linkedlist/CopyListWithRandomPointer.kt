package leetcode.linkedlist

class CopyListWithRandomPointer {
    fun copyRandomList(node: leetcode.linkedlist.RandomNode?): leetcode.linkedlist.RandomNode? {
        val originalNodes = mutableListOf<leetcode.linkedlist.RandomNode?>()
        val newNodes = mutableListOf<leetcode.linkedlist.RandomNode?>()
        val customHead = leetcode.linkedlist.RandomNode(0)
        var newListNodePointer: leetcode.linkedlist.RandomNode = customHead
        var currentNode = node

        while (currentNode != null) {
            newListNodePointer = leetcode.linkedlist.RandomNode(currentNode.`val`).also { newListNodePointer.next = it }
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
    var next: leetcode.linkedlist.RandomNode? = null
    var random: leetcode.linkedlist.RandomNode? = null
}
