package ting.leetcode.java.binarysearch;

public class BinarySearch {
    public int search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    // bisecLeft, bisecRigh 的命題是：
    // 如果我需要在給定的陣列中加入一個 target 值，我要把 target 插入在陣列的哪個 index 上，它才會是這個陣列中的第一個 target？
    public int searchLeft(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }

        return left; // 找到左邊界
//        return left < nums.length && nums[left] == target ? left : -1; // 這個條件是確保我們要找到 target 否則回傳 -1
    }

    public int searchRight(int[] arr, int target) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = ((right - left) >> 1) + left;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left; // 回傳 target 邊界 +1，所以如果想找到右邊界需要回傳 left -1
    }


    public static void main(String[] args) {
        System.err.println(5 >> 1);
        System.err.println(new BinarySearch().search(new int[]{1, 2, 3, 4, 5}, 5));
    }
}
