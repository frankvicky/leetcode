package ting.leetcode.linkedlist

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MergeTwoSortedListsTest {
    private val mergeTwoSortedLists by lazy { MergeTwoSortedLists() }

    @Test
    fun mergeTwoListsInplace() {
        var count = 1
        val list1: List<ListNode?> = generateSequence { ListNode(count++) }.take(3).toList().also { count = 1 }
        val list2: List<ListNode?> = generateSequence { ListNode(count++) }.take(3).toList()

        list1.forEachIndexed { index, node ->
            node?.next = list2[index]
            if (index + 1 <= list1.lastIndex)
                list2[index]?.next = list1[index + 1]
        }
        val list3: List<ListNode?> = generateSequence { ListNode(count++) }.take(3).toList().also { count = 1 }
        val list4: List<ListNode?> = generateSequence { ListNode(count++) }.take(3).toList()
        val resultHead = mergeTwoSortedLists.mergeTwoListsInplace(list3.first(), list4.first())
        var firstPointer = list1.first()
        var secondPointer = resultHead
        while (firstPointer != null && secondPointer != null) {
            assertEquals(firstPointer.`val`, secondPointer.`val`)
            firstPointer = firstPointer.next
            secondPointer = secondPointer.next
        }

    }
}