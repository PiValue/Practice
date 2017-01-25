package com.leetcode.list;

/**
 * Reverse given linked list.
 * 
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseList206<T> {
    public ListNode<T> reverseList(ListNode<T> head) {
        ListNode<T> prev = null;
        while(head != null) {
            ListNode<T> temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
