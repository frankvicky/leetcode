package ting.leetcode.tree

class EvenOddTree {
    fun isEvenOddTree(root: TreeNode?): Boolean {
        root ?: return true
        var level = 0
        val nodes = ArrayDeque<TreeNode>()

        nodes.add(root)
        while (nodes.isNotEmpty()) {
            val size = nodes.size
            for (i in 0 until size) {
                val node = nodes.removeFirst()

                if ((level and 1) == 1) {
                    if ((node.`val` and 1) == 1) {
                        return false
                    }

                    nodes.firstOrNull()
                        ?.let { if (i < size - 1 && node.`val` <= it.`val`) return false }
                } else {
                    if ((node.`val` and 1) == 0) {
                        return false
                    }

                    nodes.firstOrNull()
                        ?.let { if (i < size - 1 && node.`val` >= it.`val`) return false }
                }

                node.left?.let { nodes.add(it) }
                node.right?.let { nodes.add(it) }
            }
            level++
        }
        return true
    }
}
