package ting.leetcode.tree

class BinaryTreeInorderTraversal {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()

        val result = mutableListOf<Int>()
        val stack = ArrayDeque<TreeNode?>()
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
        return result
    }
}
