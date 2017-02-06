package com.leetcode.list;

public class RemoveValueFromList {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null || head.val == val) {
            return head;
        }
        
        while (head.val == val) {
            head = head.next;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (curr.val == val) {
                curr = curr.next;
            }
            else {
                prev.next = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}
