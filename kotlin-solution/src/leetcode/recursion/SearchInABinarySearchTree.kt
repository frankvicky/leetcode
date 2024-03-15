package leetcode.recursion

import leetcode.tree.TreeNode

class SearchInABinarySearchTree {
    var result: leetcode.tree.TreeNode? = null
    fun searchBST(root: leetcode.tree.TreeNode?, `val`: Int): leetcode.tree.TreeNode? =
        when {
            root == null -> null
            root.`val` == `val` -> root
            root.`val` > `val` -> searchBST(root.left, `val`)
            else -> searchBST(root.right, `val`)
        }
}
