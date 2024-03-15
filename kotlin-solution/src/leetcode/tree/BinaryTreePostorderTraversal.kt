package leetcode.tree

class BinaryTreePostorderTraversal {
    fun postorderTraversal(root: leetcode.tree.TreeNode?): List<Int> {
        if (root == null) return emptyList()
        var temp = 0

        val result = mutableListOf<Int>()
        val stack = ArrayDeque<leetcode.tree.TreeNode?>()

        stack.addFirst(root)
        var previousNode: leetcode.tree.TreeNode? = null
        while (stack.isNotEmpty()) {
            stack.run {
                val currentNode = first()
                val isNoChild = currentNode?.left == null && currentNode?.right == null
                var isChildVisited = false
                if (previousNode != null && (currentNode?.left == previousNode || currentNode?.right == previousNode)) {
                    isChildVisited = true
                }

                if (isNoChild || isChildVisited) {
                    result.add(currentNode?.`val`!!)
                    removeFirst()
                    previousNode = currentNode
                } else {
                    if (currentNode?.right != null) addFirst(currentNode.right)
                    if (currentNode?.left != null) addFirst(currentNode.left)
                }
            }
        }
        return result
    }

    fun postorderTraversalRecursion(root: leetcode.tree.TreeNode?): List<Int> =
        if (root == null)
            emptyList()
        else
            buildList {
                addAll(postorderTraversalRecursion(root.left))
                addAll(postorderTraversalRecursion(root.right))
                add(root.`val`)
            }
}
