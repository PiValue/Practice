package com.leetcode;

public class Q62_UniquePaths {



    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) return 0;

        int numRights = m - 1;
        int numDowns = n - 1;
        int numSteps = numRights + numDowns;

        double numerator = logFactorial(numSteps);
        double denominator = logFactorial(numRights) + logFactorial(numDowns);

        return (int) Math.pow(10, numerator - denominator);
    }

    private double logFactorial(int n) {
        double result = 0.0d;
        while (n > 0) {
            result += Math.log10(n--);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Q62_UniquePaths().uniquePaths(36, 7));
    }
}
