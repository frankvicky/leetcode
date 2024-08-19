package ting.datastructure.impl;

import java.util.NoSuchElementException;

public class MyDoublyLinkedList<E> {
    private static class Node<E> {
        E val;
        Node<E> next;
        Node<E> prev;;

        Node(E val) {
            this.val = val;
        }
    }

    private final Node<E> head, tail;
    private int size;

    public MyDoublyLinkedList() {
        this.head = new Node<>(null); // dummy head
        this.tail = new Node<>(null); // dummy tail
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        Node<E> currentTail = tail.prev;

        // original: currentTail <-> tail
        // we want : currentTail <-> newNode <-> tail
        currentTail.next = newNode;
        newNode.prev = currentTail;

        newNode.next = tail;
        tail.prev = newNode;

        size++;
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        Node<E> currentHead = head.next;

        // original: head <-> currentHead
        // we want: head <-> newNode <-> currentHead
        currentHead.prev = newNode;
        newNode.next = currentHead;

        newNode.prev = head;
        head.next = newNode;

        size++;
    }

    public void add(int index, E e) {
        checkPositionIndex(index);
        if (index == size) {
            addLast(e);
            return;
        }

        // original: prev <-> target
        // we want: prev  <-> newNode <-> target
        Node<E> target = getNode(index);
        Node<E> prev = target.prev;
        Node<E> newNode = new Node<>(e);

        target.prev = newNode;
        newNode.next = target;

        prev.next = newNode;
        newNode.prev = prev;

        size++;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        Node<E> currentHead = head.next;
        Node<E> newHead = currentHead.next;
        head.next = newHead;
        newHead.prev = head;

        currentHead.prev = null;
        currentHead.next = null;

        size--;
    }

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        Node<E> currentTail = tail.prev;
        Node<E> newTail = currentTail.prev;
        newTail.next = tail;
        tail.prev = newTail;
        currentTail.next = null;
        currentTail.prev = null;

        size--;
    }

    public void remove(int index) {
        checkElementIndex(index);

        Node<E> target = getNode(index);
        Node<E> previous = target.prev;
        Node<E> next = target.next;

        previous.next = next;
        next.prev = previous;

        target.prev = null;
        target.next = null;

        size --;
    }

    public E get(int index) {
        return getNode(index).val;
    }

    public E getFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        return head.next.val;
    }

    public E getLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        return tail.prev.val;
    }

    public void set(int index, E e) {
        Node<E> target = getNode(index);
        target.val = e;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void checkPositionIndex(int index) {
        if (0 >= index && index <= size) {
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    private void checkElementIndex(int index) {
         if (0 >= index && index < size) {
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    private Node<E> getNode(int index) {
        checkElementIndex(index);
        Node<E> pointer = head.next;
        for (int i = 0; i < index; i++) {
            pointer = pointer.next;
        }
        return pointer;
    }
}
