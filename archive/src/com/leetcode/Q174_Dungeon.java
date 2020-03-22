package com.leetcode;

public class Q174_Dungeon {
    private static int MIN_VALUE = 0;
    private static int HEALTH_VALUE = 0;

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) return 1;

        int ans = calculateMinimumHP(dungeon, 0, 0)[MIN_VALUE];
        return ans < 0 ? -ans + 1 : 1;
    }

    private int[] calculateMinimumHP(int[][] dungeon, int x, int y) {
        if (x >= dungeon.length || y >= dungeon[x].length) {
            return new int[] {100000000, Integer.MAX_VALUE};
        }

        int[] down = calculateMinimumHP(dungeon, x + 1, y);
        int[] right = calculateMinimumHP(dungeon, x, y + 1);

        int min = Math.abs(down[MIN_VALUE]) < Math.abs(right[MIN_VALUE]) ? down[MIN_VALUE] : right[MIN_VALUE];
        int health = Math.min(down[HEALTH_VALUE], right[HEALTH_VALUE]);
        return new int[] {min, health};
    }


    public static void main(String[] args) {
        System.out.println(new Q174_Dungeon().calculateMinimumHP(new int[][] {
                {-2, -3,  3},
                {-5, -10, 1},
                {10, 30, -5}
        }));
    }
}
