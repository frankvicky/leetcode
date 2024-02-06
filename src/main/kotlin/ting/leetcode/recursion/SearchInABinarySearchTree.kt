package ting.leetcode.recursion

import ting.leetcode.tree.TreeNode

class SearchInABinarySearchTree {
    var result: TreeNode? = null
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? =
        when {
            root == null -> null
            root.`val` == `val` -> root
            root.`val` > `val` -> searchBST(root.left, `val`)
            else -> searchBST(root.right, `val`)
        }
}