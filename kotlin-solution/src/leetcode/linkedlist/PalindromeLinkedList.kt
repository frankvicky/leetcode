package leetcode.linkedlist

class PalindromeLinkedList {
    fun isPalindrome(head: leetcode.linkedlist.ListNode?): Boolean {
        if (head?.next == null) return true
        val values = mutableListOf<Int>()
        var currentNode = head
        while (currentNode != null) {
            values.add(currentNode.`val`)
            currentNode = currentNode.next
        }
        val middle = values.lastIndex / 2

        for (i in 0..middle) {
            if (values[i] != values[values.lastIndex - i]) return false
        }
        return true
    }

    fun isPalindromeWithReversed(head: leetcode.linkedlist.ListNode?): Boolean {
        if (head?.next == null) return true
        val values = mutableListOf<Int>()
        var currentNode = head
        while (currentNode != null) {
            values.add(currentNode.`val`)
            currentNode = currentNode.next
        }
        return values == values.reversed()
    }
}
