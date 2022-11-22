import ting.leetcode.arrayandstring.*
import ting.leetcode.linkedlist.LinkedListCycleII
import ting.leetcode.linkedlist.ListNode
import ting.leetcode.linkedlist.MyLinkedList
import ting.leetcode.linkedlist.RemoveNthNodeFromEndOfList

fun main(args: Array<String>) {
    var a = 1
    var b = 2
    val testReceiver: Int.() -> Unit = { println(inc()) }
    val testReceiver1: Int.() -> String = { "${inc()} is a string: $this" }
    var c = a.apply(testReceiver)
    var d = a.also(testReceiver)
    b.testReceiver()



    println(a)
    println(b)
    println(c)
    println(d)

}

private fun Int.plus20(): Int {
    return this + 20
}

data class Test(
    private val nonNullable: Int = 12,
    private val nullable: Int? = null
)