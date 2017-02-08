package com.epi.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * From EPI book, page 92, 13.1  - accepted on Leetcode.
 * 
 * * #Leetcode: 49 - https://leetcode.com/problems/anagrams/
 * 
 * Group given list of words into group of anagrams.
 * 
 * */
public class GroupIntoAnagrams {
    public List<List<String>> groupAnagrams(List<String> words) {
        Map<String, List<String>> groups = new HashMap<String, List<String>>();
        for (String word : words) {
            String normalized = sortChars(word);
            if (!groups.containsKey(normalized)) {
                groups.put(normalized, new ArrayList<String>());
            }
            List<String> list = groups.get(normalized);
            list.add(word);
        }

        List<List<String>> result = new ArrayList<List<String>>();
        for (Entry<String, List<String>> entry : groups.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    private String sortChars(String word) {
        char []chars = word.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    
    public static void main(String[] args) {
        List<String> input = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
        GroupIntoAnagrams obj = new GroupIntoAnagrams();
        List<List<String>> output = obj.groupAnagrams(input);
        for (List<String> result : output) {
            System.out.println(result);
        }
    }
}
