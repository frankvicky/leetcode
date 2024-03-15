package leetcode.tree

class BinaryTreeInorderTraversal {
    fun inorderTraversal(root: leetcode.tree.TreeNode?): List<Int> {
        if (root == null) return emptyList()

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
        return result
    }

    fun inorderTraversalRecursion(root: leetcode.tree.TreeNode?): List<Int> =
        if (root == null)
            emptyList()
        else
            mutableListOf<Int>().apply {
                addAll(inorderTraversalRecursion(root.left))
                add(root.`val`)
                addAll(inorderTraversalRecursion(root.right))
            }
}
