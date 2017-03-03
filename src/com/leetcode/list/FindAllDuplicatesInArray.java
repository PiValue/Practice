package com.leetcode.list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindAllDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        for (int index = 0; index < nums.length; index++) {
            int i = Math.abs(nums[index]) - 1;
            if (nums[i] > 0) {
                nums[i] = -nums[i];
            }
        }
        return IntStream.range(0, nums.length)
                        .filter(index -> nums[index] > 0)
                        .map(num -> num+1)
                        .boxed()
                        .collect(Collectors.toList());
    }
    
    public static void main(String[] args) {
        int []arr = {4,3,2,7,8,2,3,1};
        FindAllDuplicatesInArray obj = new FindAllDuplicatesInArray();
        obj.findDuplicates(arr).stream().forEach(System.out::println);
    }
}
