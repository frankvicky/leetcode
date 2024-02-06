package ting.leetcode.tree

class BinaryTreePreorderTraversal {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()

        val result = mutableListOf<Int>()
        val stack = ArrayDeque<TreeNode?>()

        stack.addFirst(root)
        while (stack.isNotEmpty()) {
            stack.run {
                val node = removeFirst()
                result.add(node?.`val`!!)
                if (node.right != null) addFirst(node.right)
                if (node.left != null) addFirst(node.left)
            }
        }

        return result
    }

    fun preorderTraversalRecursion(root: TreeNode?): List<Int> =
        if (root == null)
            emptyList()
        else
            buildList {
                add(root.`val`)
                addAll(preorderTraversalRecursion(root.left))
                addAll(preorderTraversalRecursion(root.right))
            }

}
