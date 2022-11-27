package ting.java.leetcode.queueandstack;

import java.util.ArrayList;
import java.util.List;


public class MyCircularQueue {
    private List<Integer> data;
    private int headIndex = -1;
    private int tailIndex = -1;


    public MyCircularQueue(int k) {
        this.data = new ArrayList<>(k) {{
            for (int i = 0; i < k; i++) {
                add(-1);
            }
        }};
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        if (isEmpty()) {
            headIndex = 0;
            tailIndex = 0;
            data.set(tailIndex, value);
            return true;
        }

        tailIndex = indexPlusOne(tailIndex);
        data.set(tailIndex, value);
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        if (headIndex != -1) data.set(headIndex, -1);
        headIndex = indexPlusOne(headIndex);
        return true;
    }

    public int Front() {
        return headIndex == -1 ? -1 : data.get(headIndex);
    }

    public int Rear() {
        return tailIndex == -1 ? -1 : data.get(tailIndex);
    }

    public boolean isEmpty() {
        var case1 = Math.abs(tailIndex - headIndex) == 1 && data.get(headIndex) == -1;
        var case2 = headIndex == -1 && tailIndex == -1;
        return case1 || case2;
    }

    public boolean isFull() {
        var tailIndex = this.tailIndex;
        if (tailIndex == data.size() - 1) {
            tailIndex = 0;
            return tailIndex == headIndex && data.get(tailIndex) != -1;
        }
        return tailIndex + 1 == headIndex && data.get(tailIndex) != -1;
    }

    private int indexPlusOne(int index) {
        return index == data.size() - 1 ? 0 :  index + 1;
    }
}
