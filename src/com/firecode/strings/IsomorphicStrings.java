package com.firecode.strings;

import java.util.*;

public class IsomorphicStrings {


public static boolean isIsomorphic(String input1, String input2) {
    if (input1 == null || input2 == null) {
        return input1 == input2;
    }
    if (input1.length() != input2.length()) {
        return false;
    }

    Set<Character> seen = new HashSet<Character>();
    Map<Character, Character> mapping = new HashMap<Character, Character>();
    for (int index = 0; index < input1.length(); index++) {
        if (!mapping.containsKey(input1.charAt(index))) {
            if (seen.contains(input1.charAt(index))) {
                return false;
            }
            mapping.put(input1.charAt(index), input2.charAt(index));
        }
        if (mapping.get(input1.charAt(index)) != input2.charAt(index)) {
            return false;
        }
    }
    return true;
}


public static void main(String[] args) {
    System.out.println(IsomorphicStrings.isIsomorphic("abcd", "aabb"));
}
}
