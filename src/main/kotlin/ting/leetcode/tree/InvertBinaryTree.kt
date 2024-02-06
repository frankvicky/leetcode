package ting.leetcode.tree

class InvertBinaryTree {
    fun invertTree(root: TreeNode?): TreeNode? {
        var temp = 0
        if (root == null) return null

        val stack = ArrayDeque<TreeNode?>()
        stack.addFirst(root);
        while (stack.isNotEmpty()) {
            stack.run {
                val currentNode = removeFirst()
                currentNode?.right = currentNode?.left.also { currentNode?.left = currentNode?.right }
                if (currentNode?.right != null) addFirst(currentNode.right)
                if (currentNode?.left != null) addFirst(currentNode.left)
            }
        }
        return root
    }

    fun invertTreeRecursion(root: TreeNode?): TreeNode? {
        if (root == null) return null

        invertTreeRecursion(root.left)
        invertTreeRecursion(root.right)

        root.left = root.right.also { root.right = root.left }
        return root
    }
}