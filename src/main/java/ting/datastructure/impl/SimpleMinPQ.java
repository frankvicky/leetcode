package ting.datastructure.impl;


class SimpleMinPQ {
    private final int[] heap;
    private int size;

    public SimpleMinPQ(int capacity) {
        // Now we use heap[0], so we don't need extra space
        heap = new int[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    // Parent node index
    int parent(int node) {
        return (node - 1) / 2;
    }

    // Left child index
    int left(int node) {
        return 2 * node + 1;
    }

    // Right child index
    int right(int node) {
        return 2 * node + 2;
    }

    // Swap two elements in the array
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Peek at the top element, O(1)
    public int peek() {
        return heap[0];
    }

    // Insert an element, O(log N)
    public void push(int x) {
        // Place the new element at the end
        heap[size] = x;
        // Swim up to the correct position
        swim(size);
        size++;
    }

    // Remove the top element, O(log N)
    public int pop() {
        int res = heap[0];
        // Move the last element to the top
        size--;
        heap[0] = heap[size];
        // Sink down to the correct position
        sink(0);
        return res;
    }

    // Swim up operation, O(log N)
    private void swim(int x) {
        while (x > 0 && heap[parent(x)] > heap[x]) {
            swap(parent(x), x);
            x = parent(x);
        }
    }

    // Sink down operation, O(log N)
    private void sink(int x) {
        while (true) {
            int root = x;
            int left = left(x);
            int right = right(x);

            if (left < size && heap[left] < heap[root]) {
                root = left;
            }
            if (right < size && heap[right] < heap[root]) {
                root = right;
            }
            if (root == x) {
                break;
            }
            swap(x, root);
            x = root;
        }
    }
}
