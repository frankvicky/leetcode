package ting.leetcode.java.arrays101;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagramsFail(String[] strs) {
        HashMap<Integer, List<String>> asciiTotalToStrings = new HashMap<>();
        for (String str : strs) {
            int asciiProduct = 1;
            char[] charArray = str.toCharArray();
            for (char c : charArray) {
                asciiProduct *= c;
            }
            int key = asciiProduct;
            asciiTotalToStrings.putIfAbsent(key, new ArrayList<>());
            asciiTotalToStrings.get(key).add(str);

        }

        return new ArrayList<>(asciiTotalToStrings.values());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = String.valueOf(chars);

            map.computeIfAbsent(sortedWord, v -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagramsFastest(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] count = new char[26];
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                count[c - 'a']++;
            }
            String str = String.valueOf(count);
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagramsCustomHash(String[] strs) {
        Map<Key, List<String>> map = new HashMap<>();

        for (String word : strs) {
            Key key = new Key(word);

            map.computeIfAbsent(key, v -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }

    static class Key {
        int[] count = new int[26];

        public Key(String word) {
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key = (Key) o;

            return Arrays.equals(count, key.count);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(count);
        }
    }

    public static void main(String[] args) {
        String[] a = {"", "b"};
        groupAnagramsFail(a);
    }
}
