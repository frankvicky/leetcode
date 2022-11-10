package ting.leetcode.linkedlist

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ReverseLinkedListTest {
    private val reverseLinkedList by lazy { ReverseLinkedList() }


    @Test
    fun reverseListWithFiveNodes(): Unit {

        var value = 1
        val nodes = generateSequence {
            ListNode(value++)
        }.take(5).toList()

        for (i in 0 until nodes.lastIndex) {
            nodes[i].next = nodes[i + 1]
        }

        reverseLinkedList.reverseList(nodes[0])
        var headNode: ListNode? = nodes.last()
        nodes.reversed().forEach {
            assertEquals(it, headNode)
            headNode = headNode?.next
        }
    }

    @Test
    fun reverseListWithTwoNodes(): Unit {
        val node1 = ListNode(1)
        val node2 = ListNode(2)

        node1.next = node2
        val nodes = listOf(node1, node2).reversed()
        reverseLinkedList.reverseList(node1)
        var currentNode: ListNode? = node2
        nodes.forEach {
            assertEquals(it, currentNode)
            currentNode = currentNode?.next
        }
    }

    @Test
    fun reverseListWithEmptyLinkedList(): Unit {
        val node = null
        reverseLinkedList.reverseList(node)
        assertNull(node)
    }
}