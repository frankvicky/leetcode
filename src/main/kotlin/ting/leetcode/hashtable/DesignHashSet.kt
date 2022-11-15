package ting.leetcode.hashtable

class MyHashSet() {
    private val size: Int = 100001
    private val bucket = Array(size) { mutableListOf<Int>() }

    fun add(key: Int) = hash(key).also { if (!contains(it)) bucket[it].add(key) }

    fun remove(key: Int) = hash(key).also { if (contains(it)) bucket[it].remove(key) }

    fun contains(key: Int): Boolean = bucket[hash(key)].contains(key)

    private fun hash(key: Int): Int = key % size
}