package com;

// Leetcode: 875
public class Koko {
    public int minEatingSpeed(int[] piles, int hours) {
        long total = 0, max = 0;
        for (int pile : piles) {
            total += pile;
            max = Math.max(max, pile);
        }
        long start = (int) Math.floor((double)total/hours);
        long end = max;

        long mid = -1;

        System.out.println(canFinishAll(piles, 4, hours));
        while (start <= end) {
            mid = (start + end)/2;
            if (canFinishAll(piles, mid, hours)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return (int) mid;
    }

    private boolean canFinishAll(int[] piles, long rate, int availableTime) {
        int timeReqd = 0;
        for (int pile : piles) {
            timeReqd += (int) Math.ceil((double)pile/rate);
        }
        return timeReqd <= availableTime;
    }

    public static void main(String[] args) {
        System.out.println(new Koko().minEatingSpeed(new int[] {332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184},
                823855818));
    }
}
