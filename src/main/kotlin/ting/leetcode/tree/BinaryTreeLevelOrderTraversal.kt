package ting.leetcode.tree

class BinaryTreeLevelOrderTraversal {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()
        val result = mutableListOf<MutableList<Int>>();
        val queue = ArrayDeque<TreeNode?>();
        queue.addLast(root)

        while (queue.isNotEmpty()) {
            val list = mutableListOf<Int>()
            for (i in queue.indices) {
                val node = queue.removeFirst()
                list.add(node?.`val`!!)
                if (node.left != null) queue.addLast(node.left)
                if (node.right != null) queue.addLast(node.right)
            }
            result.add(list);
        }
        return result
    }
}