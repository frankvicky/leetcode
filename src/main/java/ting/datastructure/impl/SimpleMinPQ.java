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
    private int parent(int nodeIndex) {
        return (nodeIndex - 1) / 2;
    }

    // Left child index
    private int left(int nodeIndex) {
        return 2 * nodeIndex + 1;
    }

    // Right child index
    private int right(int nodeIndex) {
        return 2 * nodeIndex + 2;
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
    public void push(int newNode) {
        // Place the new element at the end
        heap[size] = newNode;
        // Swim up to the correct position
        swim(size);
        size++;
    }

    // Remove the top element, O(log N)
    public int pop() {
        int pop = heap[0];
        // Move the last element to the top
        heap[0] = heap[size - 1];
        size--;
        // Sink down to the correct position
        sink(0);
        return pop;
    }

    // Swim up operation, O(log N)
    private void swim(int nodeIndex) {
        while (nodeIndex > 0 && heap[parent(nodeIndex)] > heap[nodeIndex]) {
            swap(parent(nodeIndex), nodeIndex);
            nodeIndex = parent(nodeIndex);
        }
    }

    // Sink down operation, O(log N)
    private void sink(int nodeIndex) {
        while (true) {
            int root = nodeIndex;
            int left = left(nodeIndex);
            int right = right(nodeIndex);

            if (left < size && heap[left] < heap[root]) {
                root = left;
            }
            if (right < size && heap[right] < heap[root]) {
                root = right;
            }
            if (root == nodeIndex) {
                break;
            }
            swap(nodeIndex, root);
            nodeIndex = root;
        }
    }

    // Sink down operation, O(log N) - Recursive version
    private void sinkRecursion(int nodeIndex) {
        int root = nodeIndex;
        int left = left(nodeIndex);
        int right = right(nodeIndex);

        // Find the smallest value among root, left, and right
        if (left < size && heap[left] < heap[root]) {
            root = left;
        }
        if (right < size && heap[right] < heap[root]) {
            root = right;
        }

        // If the smallest value is not the current node, swap and recurse
        if (root != nodeIndex) {
            swap(nodeIndex, root);
            sink(root); // Recurse on the affected subtree
        }
    }
}
