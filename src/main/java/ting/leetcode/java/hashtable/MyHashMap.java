package ting.leetcode.java.hashtable;

import java.util.Arrays;

public class MyHashMap {

    private final int[] cache = new int[100_000_1];

    public MyHashMap() {
        Arrays.fill(cache, -1);
    }

    public void put(int key, int value) {
        cache[key] = value;
    }

    public int get(int key) {
        return cache[key];
    }

    public void remove(int key) {
        cache[key] = -1;
    }
}

class MyHashMapWithNode {
    private static final int MOD = 100001;
    private final Node[] buckets = new Node[MOD];

    public MyHashMapWithNode() {

    }

    public void put(int key, int value) {
        int hash = hash(key);
        Node node = buckets[hash];

        // 如果鍵已存在，更新值
        while (node != null) {
            if (node.key == key) {
                node.value = value;
                return;
            }
            node = node.next;
        }

        // 插入新的節點
        Node newNode = new Node(key, value, buckets[hash]);
        buckets[hash] = newNode;
    }


    public int get(int key) {
        int hash = hash(key);
        Node node = buckets[hash];
        while (node != null) {
            if (node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }

    public void remove(int key) {
        int hash = hash(key);
        Node node = buckets[hash];
        if (node == null) {
            return;
        }

        if (node.key == key) {
            buckets[hash] = node.next; // like stack.pop()
            return;
        }

        while (node.next != null) {
            if (node.next.key == key) {
                node.next = node.next.next;
                return;
            }
            node = node.next;
        }
    }

    // 在 remove(int key) 方法中，它的目的是將鍵等於給定鍵的節點從鍵值對列表（用鍵的哈希決定的特定桶）中移除。
    //第一個 if 條件檢查當前桶（由鍵的哈希決定）是否為空。如果為空，那麼沒有可移除的節點，所以它立刻返回。
    //第二個 if 條件檢查桶的第一個節點（即桶的頭部）的鍵是否與要移除的鍵相同。如果相相同，則將桶的頭部設置為下一個節點（或者如果沒有下一個節點，則會設置為 null），就像從堆疊中彈出元素一樣。
    //如果第一個節點的鍵不是我們要尋找的鍵，那麼我們需要進入到第三個 while 迴圈中。在while迴圈中，程式碼將遍歷此桶中的每一個節點，直到找到鍵相匹配的節點，或是遍歷完所有的節點（node.next 為 null）。
    //在迴圈中，如果找到相匹配的鍵（node.next.key == key），則將當前節點的 next 指針，指向下下個節點（node.next.next）。這種做法會將下一個節點（即鍵相匹配的節點）從連結列表中移除。在完成這個操作後，函數立刻返回。
    //如果完成了while迴圈（即遍歷了所有節點），則這個函數結束，並不執行任何操作。這是因為函數未找到鍵相匹配的節點來移除。

    private int hash(int key) {
        return (key & 0x7FFFFFFF) % buckets.length;
    }
}

class Node {
    int key;
    int value;
    Node next;

    public Node() { }

    public Node(int key, int value, Node next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}