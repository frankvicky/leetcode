package ting.datastructure.impl;

import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * PQ 實現，以 minHeap 為基礎
 * @param <T>
 */
public class MyPriorityQueue<T> {
    private T[] heap;
    private int size;
    private final Comparator<? super T> comparator;

    @SuppressWarnings("unchecked")
    public MyPriorityQueue(int capacity, Comparator<? super T> comparator) {
        heap = (T[]) new Object[capacity];
        size = 0;
        this.comparator = comparator;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 父节点的索引
    private int parent(int node) {
        return (node - 1) >> 1;
    }

    // 左子节点的索引
    private int left(int node) {
        return (node << 1) + 1;
    }

    // 右子节点的索引
    private int right(int node) {
        return (node << 1) + 2;
    }

    // 交换数组的两个元素
    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // 查，返回堆顶元素，时间复杂度 O(1)
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        return heap[0];
    }

    // 增，向堆中插入一个元素，时间复杂度 O(logN)
    public void push(T x) {
        if (size == heap.length) {
            resize(2 * heap.length);
        }

        heap[size] = x;
        swim(size);
        size++;
    }


    // 删，删除堆顶元素，时间复杂度 O(logN)
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        T res = heap[0];
        size--; // size-- 之後等於最後一個元素的 index
        heap[0] = heap[size];
        heap[size] = null;
        sink(0);
        if ((size > 0) && (size == heap.length / 4)) {
            resize(heap.length / 2);
        }
        return res;
    }


    /**
     * 上浮操作，时间复杂度是树高 O(logN)
     * @param k index of node, because we use array to simulate a binary tree.
     */
    private void swim(int k) {
        // 当 k 不为堆顶（索引为 0）并且当前节点小于其父节点时，执行循环
        while (k > 0 && comparator.compare(heap[parent(k)], heap[k]) > 0) {
            // 交换当前节点与父节点的位置，使较小的元素上移
            swap(parent(k), k);
            // 更新 k 为父节点的索引，继续向上比较
            k = parent(k);
        }
    }

    /**
     * 下沉操作，时间复杂度是树高 O(logN)
     * @param k index of node, because we use array to simulate a binary tree.
     */
    private void sink(int k) {
        // 当左子节点存在时，执行循环
        while (left(k) < size) {
            int j = left(k); // 假设左子节点较小
            // 如果右子节点存在且右子节点小于左子节点，则选择右子节点
            if (j + 1 < size && comparator.compare(heap[j], heap[j + 1]) > 0) {
                j++; // 指向右子节点
            }
            // 如果当前节点小于等于子节点中较小的那个，堆已经有序，退出循环
            if (comparator.compare(heap[k], heap[j]) <= 0) {
                break;
            }
            // 交换当前节点与较小子节点的位置，使较大的元素下移
            swap(k, j);
            // 更新 k 为子节点的索引，继续向下比较
            k = j;
        }
    }

    // 调整堆的大小
    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        assert capacity >= size;
        T[] temp = (T[]) new Object[capacity];
        if (size >= 0)
            System.arraycopy(heap, 0, temp, 0, size);
        heap = temp;
    }

    public static void main(String[] args) {
        MyPriorityQueue<Integer> pq = new MyPriorityQueue<>(3, Comparator.naturalOrder());
        pq.push(3);
        pq.push(1);
        pq.push(4);
        pq.push(1);
        pq.push(5);
        pq.push(9);
        while (!pq.isEmpty()) {
            System.out.println(pq.pop());
        }
    }
}
