package ting.leetcode.java.binarysearch;

public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        // max: 單個最重包裹，邏輯上運輸工具不會連一個包裹都裝不下
        // sum: 總量，最理想狀況一趟運完
        int max = 0, sum = 0;
        for (int w : weights) {
            max = Math.max(max, w);
            sum += w;
        }
        int low = max, high = sum;

        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (exceedLimit(weights, days, mid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private boolean exceedLimit(int[] weights, int limitDays, int capacity) {
        int costDays = 1;
        int remainingCapacity = capacity;
        for (int weight : weights) {
            if (remainingCapacity < weight) {
                costDays++;
                remainingCapacity = capacity;
            }
            remainingCapacity -= weight;
        }
        return costDays > limitDays;
    }
}
