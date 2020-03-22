package com.twitter;

public class RemoveDuplicates {
    public int removeDuplicate(int[] input) {
        if (input == null || input.length == 0) return 0;
        if (input[0] == Integer.MAX_VALUE) return 1;

        int prev = Integer.MAX_VALUE;
        int i = 0;
        for (int runner = 0; runner < input.length; runner++) {
            if (prev != input[runner]) {
                // New unique value.
                input[i++] = input[runner];
                prev = input[runner];
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] input = new int[] {1, 1, 3, 3, 3, 6, 8, 9, 9, 9, 9, 9, 9, 9, 9, 10};
        int newSize = new RemoveDuplicates().removeDuplicate(input);

        int i = 0;
        while (i < newSize) {
            System.out.print(input[i++] + ", ");
        }
    }
}
