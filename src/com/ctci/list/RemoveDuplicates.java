package com.ctci.list;

import java.util.HashSet;
import java.util.Set;

import com.leetcode.list.ListNode;

/**
 * CTCI page 63 - problem 2.1
 * Remove duplicates from an unsorted linked list.
 * */
public class RemoveDuplicates {
    public ListNode removeDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        Set<Integer> values = new HashSet<Integer>();
        ListNode curr = head;
        ListNode runner = head.next;
        values.add(curr.val);
        
        while (runner != null) {
            if (values.contains(runner.val)) {
                // Duplicate - skip this
                runner = runner.next;
            } else {
                // New element - connect curr to this node and move both
                curr.next = runner;
                curr = curr.next;
                runner = runner.next;
                values.add(curr.val);
            }
        }
        curr.next = null;
        return head;
    }
}
