package ting.datastructure.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyLinkedHashMap<K, V> {
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;
        Node<K, V> prev;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Node<K, V> head;
    private final Node<K, V> tail;
    private final HashMap<K, Node<K, V>> map = new HashMap<>();

    public MyLinkedHashMap() {
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public void put(K key, V value) {
        if (!map.containsKey(key)) {
            Node<K, V> node = new Node<>(key, value);
            addLastNode(node);
            map.put(key, node);
            return;
        }
        // if exist then replace with new value
        map.get(key).value = value;
    }

    public void remove(K key) {
        if (!map.containsKey(key)) {
            return;
        }
        Node<K, V> node = map.get(key);
        map.remove(key);
        removeNode(node);
    }

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    public List<K> keys() {
        List<K> keys = new ArrayList<>();
        for (Node<K, V> node = head.next; node != tail; node = node.next) {
            keys.add(node.key);
        }
        return keys;
    }

    public int size() {
        return map.size();
    }

    private void addLastNode(Node<K, V> node) {
        Node<K, V> temp = tail.prev;
        node.next = tail;
        node.prev = temp;

        temp.next = node;
        tail.prev = node;
    }

    private void removeNode(Node<K, V> node) {
        Node<K, V> prev = node.prev;
        Node<K, V> next = node.next;

        prev.next = next;
        next.prev = prev;

        node.next = node.prev = null;
    }
}
