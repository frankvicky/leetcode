package ting.leetcode.linkedlist

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.random.Random

internal class RemoveLinkedListElementsTest {

    private val removeLinkedListElements by lazy { RemoveLinkedListElements() }

    @Test
    fun removeElements(): Unit {
        val node1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(3)
        val node4 = ListNode(4)
        val node5 = ListNode(5)
        val node6 = ListNode(6)
        val node7 = ListNode(6)

        node1.next = node2
        node2.next = node6
        node6.next = node3
        node3.next = node4
        node4.next = node5
        node5.next = node7

        val nodes = mutableListOf(node1, node2, node6, node3, node4, node5, node7)
        val random = Random.nextInt(nodes.size)
        val result = nodes.filterNot { it.`val` == random }
        val head = removeLinkedListElements.removeElements(node1, random)
        var currentNode = head

        result.forEach {
            assertEquals(it.`val`, currentNode?.`val`)
            currentNode = currentNode?.next
        }

    }

    @Test
    fun removeElementsOnSameElementsList(): Unit {
        val node1 = ListNode(7)
        val node2 = ListNode(7)
        val node3 = ListNode(7)
        val node4 = ListNode(7)

        node1.next = node2
        node2.next = node3
        node3.next = node4


        val nodes = mutableListOf(node1, node2, node3, node4)
        val target = 7
        val result = nodes.filterNot { it.`val` == target }
        val head = removeLinkedListElements.removeElements(node1, target)
        var currentNode = head

        result.forEach {
            assertEquals(it, currentNode)
            currentNode = currentNode?.next
        }

    }
}