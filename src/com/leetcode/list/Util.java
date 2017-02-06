package com.leetcode.list;

import java.util.HashSet;
import java.util.Set;

public class Util {
    public ListNode makeList(int []array) {
        if (array == null || array.length == 0) {
            return null;
        }

        ListNode prev = null;
        for (int index = array.length - 1; index >= 0; index--) {
            ListNode head  = new ListNode(array[index], prev);
            prev = head;
        }
        return prev;
    }

    public void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
    }
    
    public Set<Integer> toSet(ListNode head) {
        Set<Integer> values = new HashSet<Integer>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }
        return values;
    }
    
    public int listLen(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
