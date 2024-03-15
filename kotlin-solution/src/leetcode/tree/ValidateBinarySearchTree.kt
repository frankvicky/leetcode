package leetcode.tree

class ValidateBinarySearchTree {
    fun isValidBST(root: leetcode.tree.TreeNode?): Boolean {
        val result = mutableListOf<Int>()
        val stack = ArrayDeque<leetcode.tree.TreeNode?>()
        var currentNode = root;

        while (currentNode != null || stack.isNotEmpty()) {
            stack.run {
                if (currentNode != null) {
                    addFirst(currentNode)
                    currentNode = currentNode?.left
                } else {
                    currentNode = removeFirst()
                    result.add(currentNode?.`val`!!)
                    currentNode = currentNode?.right
                }
            }
        }

        for (i in 0 until result.lastIndex)
            if (result[i] >= result[i + 1]) return false

        return true
    }
}
