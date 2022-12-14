package ting.leetcode.tree

class MaximumDepthOfBinaryTree {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        val result = mutableListOf<MutableList<TreeNode?>>();
        val queue = ArrayDeque<TreeNode?>();
        queue.addLast(root)

        while (queue.isNotEmpty()) {
            val list = mutableListOf<TreeNode?>()
            for (i in queue.indices) {
                val node = queue.removeFirst()
                list.add(node)
                if (node?.left != null) queue.addLast(node.left)
                if (node?.right != null) queue.addLast(node.right)
            }
            result.add(list);
        }
        return result.size
    }
}