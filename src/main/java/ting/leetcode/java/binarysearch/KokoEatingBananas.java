package ting.leetcode.java.binarysearch;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int H) {
        // high 的設定是因為題目設定一疊香蕉最多可能有 10 的 9 次方個
        // 代表 Koko 最快速一次可以吃  10 的 9 次方個香蕉
        int low = 1, high = 1_000_000_000;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (exceedLimited(piles, H, mid))
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    public boolean exceedLimited(int[] piles, int limitHour, int speed) {
        int costHours = 0;
        for (int pile: piles)
            costHours += (pile - 1) / speed + 1;
        // 如果超過 costHour > limitHour，也就是 當前吃香蕉速度 太慢
        // 因此吃完時超過指定時間
        // 代表我們速度離比期望速度慢。
        return costHours > limitHour;
    }
}
