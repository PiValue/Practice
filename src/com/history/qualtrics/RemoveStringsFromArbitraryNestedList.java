package com.history.qualtrics;

import java.util.ArrayList;
import java.util.List;

/**
 * Remove first occurrence of given string from arbitrarily nested string.
 * */
public class RemoveStringsFromArbitraryNestedList {
    private List<Object> findFirstOccrrence(List<Object> list, String target, boolean hasFound) {
        if (list == null || list.isEmpty() || target == null) {
            return list == null ? list : new ArrayList<>();
        }

        for (Object value : list) {
            if (value instanceof String) {
                if (!hasFound) {
                    
                }
            }
        }
        return null;
    }
}
