package com.leetcode.list;

/**
 * Reverse given linked list.
 * 
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseList206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
