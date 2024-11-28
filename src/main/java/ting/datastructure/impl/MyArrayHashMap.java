package ting.datastructure.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class MyArrayHashMap<K, V> {
    private static class Node<K, V> {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // 存储 key 和 key 在 arr 中的索引
    private final HashMap<K, Integer> map = new HashMap<>();
    // 真正存储 key-value 的数组
    private final ArrayList<Node<K, V>> arr = new ArrayList<>();

    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }

        int index = map.get(key);
        return arr.get(index).value;
    }

    public void put(K key, V value) {
        if (containsKey(key)) {
            int i = map.get(key);
            Node<K, V> node = arr.get(i);
            node.value = value;
            return;
        }

        arr.addLast(new Node<>(key, value));
        map.put(key, arr.size() - 1);
    }

    public void remove(K key) {
        if (!map.containsKey(key)) {
            return;
        }

        int index = map.get(key);
        Node<K, V> node = arr.get(index);

        // 1. 最后一个元素 element 和第 index 个元素 node 换位置
        Node<K, V> element = arr.get(arr.size() - 1);
        arr.set(index, element);
        arr.set(arr.size() - 1, node);

        // 2. 修改 map 中 e.key 对应的索引
        map.put(element.key, index);

        // 3. 在数组中删除最后一个元素
        arr.removeLast();

        // 4. 在 map 中删除 node.key
        map.remove(node.key);
    }

    public K randomKey() {
        int randomIndex = ThreadLocalRandom.current().nextInt(arr.size());
        return arr.get(randomIndex).key;
    }


    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    public int size() {
        return map.size();
    }
}
