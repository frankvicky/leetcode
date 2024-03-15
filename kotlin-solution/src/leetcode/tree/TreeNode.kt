package leetcode.tree

import java.util.*

class TreeNode(var `val`: Int) {
    var left: leetcode.tree.TreeNode? = null
    var right: leetcode.tree.TreeNode? = null


    fun arrayToTreeNode(arr: Array<Int?>): leetcode.tree.TreeNode? {
        if (arr.isEmpty() || arr[0] == null) {
            return null
        }

        val root = leetcode.tree.TreeNode(arr[0]!!)
        val queue: Queue<leetcode.tree.TreeNode> = LinkedList()
        queue.offer(root)
        var index = 1

        while(index < arr.size){
            val curr = queue.poll()

            // Process the left child
            if (arr[index] != null) {
                curr.left = leetcode.tree.TreeNode(arr[index]!!)
                queue.offer(curr.left)
            }
            index++

            if (index >= arr.size) {
                break
            }

            // Process the right child
            if (arr[index] != null) {
                curr.right = leetcode.tree.TreeNode(arr[index]!!)
                queue.offer(curr.right)
            }
            index++
        }

        return root
    }
}
