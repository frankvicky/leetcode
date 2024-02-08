package ting.leetcode.java.queueandstack;

import java.util.*;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        int[] cache = new int[128];
        PriorityQueue<Item> queue = new PriorityQueue<>((i1, i2) -> i2.frequency - i1.frequency);
        for (char c : s.toCharArray()) {
            ++cache[c];
        }

        for (int i = 0; i < cache.length; i++) {
            queue.offer(new Item((char) (i), cache[i]));
        }

        StringBuilder ans = new StringBuilder();
        while (!queue.isEmpty()) {
            Item item = queue.poll();
            ans.append(String.valueOf(item.symbol).repeat(item.frequency));
        }

        return ans.toString();
    }

    public String frequencySortTreeMap(String s) {
        int[] cache = new int[128];
        Set<Item> items = new TreeSet<>();
        for (char c : s.toCharArray()) {
            ++cache[c];
        }

        for (int i = 0; i < cache.length; i++) {
            items.add(new Item((char) (i), cache[i]));
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Item item : items) {
            stringBuilder.append(String.valueOf(item.symbol).repeat(item.frequency));
        }

        return stringBuilder.toString();
    }

    class Item implements Comparable<Item> {
        Character symbol;
        int frequency;

        public Item(Character symbol, int frequency) {
            this.symbol = symbol;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Item o) {
            int frequencyComparison = o.frequency - this.frequency;
            if (frequencyComparison == 0) {
                return this.symbol.compareTo(o.symbol);
            }
            return frequencyComparison;
        }
    }
}
