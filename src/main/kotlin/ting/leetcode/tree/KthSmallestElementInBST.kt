package ting.leetcode.tree

class KthSmallestElementInBST {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
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

        return result.run {
            sort()
            get(k - 1)
        }
    }

    fun kthSmallestRecursion(root: TreeNode?, k: Int): Int = recursion(root)[k - 1]

    fun recursion(root: TreeNode?): List<Int> =
        if (root == null)
            emptyList()
        else
            mutableListOf<Int>().apply {
                addAll(recursion(root.left))
                add(root.`val`)
                addAll(recursion(root.right))
            }


}