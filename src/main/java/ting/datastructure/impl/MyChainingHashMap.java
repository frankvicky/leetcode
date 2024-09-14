package ting.datastructure.impl;

import java.util.LinkedList;
import java.util.List;

public class MyChainingHashMap<K, V> {
    private static class Node<K, V> {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Node<K, V>>[] buckets;

    private int size;

    private static final int INITIAL_CAPACITY = 4;

    public MyChainingHashMap() {
        this(INITIAL_CAPACITY);
    }

    public MyChainingHashMap(int capacity) {
        size = 0;
        int initialCapacity = Math.max(capacity, 1);
        buckets = (LinkedList<Node<K,V>>[]) new LinkedList[initialCapacity];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        LinkedList<Node<K, V>> bucket = buckets[hash(key)];
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }

        bucket.add(new Node<>(key, value));
        size++;

        if (size > buckets.length * 0.75) {
            resize(buckets.length * 2);
        }
    }

    public void remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        LinkedList<Node<K, V>> bucket = buckets[hash(key)];
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                bucket.remove(node);
                size--;

                if (size < buckets.length / 8) {
                    resize(buckets.length / 4);
                }
                return;
            }
        }
    }

    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        LinkedList<Node<K, V>> bucket = buckets[hash(key)];
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    public List<K> keys() {
        List<K> keys = new LinkedList<>();
        for (LinkedList<Node<K, V>> bucket : buckets) {
            for (Node<K, V> node : bucket) {
                keys.add(node.key);
            }
        }
        return keys;
    }

    public int size() {
        return size;
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % buckets.length;
    }

    private void resize(int size) {
        size = Math.max(size, 1);
        MyChainingHashMap<K, V> newMap = new MyChainingHashMap<>(size);

        for (LinkedList<Node<K, V>> bucket : buckets) {
            for (Node<K, V> node : bucket) {
                newMap.put(node.key, node.value);
            }
        }
        this.buckets = newMap.buckets;
    }
}
