package ting.leetcode.java.sorting;

public class StringSorting {
    public String sorting(String s) {
        String[] split = s.split(",");
        mergeSort(split, 0, split.length - 1, new String[split.length]);
        return String.join(",", split);
    }

    private void mergeSort(String[] arr, int left, int right, String[] cache) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid, cache);
        mergeSort(arr, mid + 1, right, cache);
        merge(arr, left, mid, right, cache);
    }


    private void merge(String[] arr, int left, int mid, int right, String[] cache) {
        int leftIndex = left;
        int rightIndex = mid + 1;
        int cacheIndex = 0;
        int arrIndex = left;

        while (leftIndex <= mid && rightIndex <= right) {
            if (compare(arr[leftIndex], arr[rightIndex])) {
                cache[cacheIndex++] = arr[leftIndex++];
            } else {
                cache[cacheIndex++] = arr[rightIndex++];
            }
        }

        while (leftIndex <= mid) {
            cache[cacheIndex++] = arr[leftIndex++];
        }

        while (rightIndex <= right) {
            cache[cacheIndex++] = arr[rightIndex++];
        }

        cacheIndex = 0;
        while (arrIndex <= right) {
            arr[arrIndex++] = cache[cacheIndex++];
        }
    }

    private boolean compare(String str1, String str2) {
        char[] aArr = str1.toCharArray();
        char[] bArr = str2.toCharArray();
        int p1 = 0, p2 = 0;
        while (p1 < aArr.length && p2 < bArr.length) {
            if (aArr[p1] != bArr[p2]) {
                return aArr[p1] - bArr[p2] < 0;
            } else {
                p1++;
                p2++;
            }
        }

        // Check which string has remaining characters
        if (p1 < aArr.length) {
            // str1 has remaining characters, hence it's greater
            return false;
        } else if (p2 < bArr.length) {
            // str2 has remaining characters, hence it's greater
            return true;
        }

        // If both strings have been fully compared, they're equal
        return false;
    }
}
