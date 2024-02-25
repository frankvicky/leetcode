package ting.leetcode.tree

import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null


    fun arrayToTreeNode(arr: Array<Int?>): TreeNode? {
        if (arr.isEmpty() || arr[0] == null) {
            return null
        }

        val root = TreeNode(arr[0]!!)
        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)
        var index = 1

        while(index < arr.size){
            val curr = queue.poll()

            // Process the left child
            if (arr[index] != null) {
                curr.left = TreeNode(arr[index]!!)
                queue.offer(curr.left)
            }
            index++

            if (index >= arr.size) {
                break
            }

            // Process the right child
            if (arr[index] != null) {
                curr.right = TreeNode(arr[index]!!)
                queue.offer(curr.right)
            }
            index++
        }

        return root
    }
}
