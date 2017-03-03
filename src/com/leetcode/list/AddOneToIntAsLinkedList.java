package com.leetcode.list;

/**
 * 
 * Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * The digits are stored such that the most significant digit is at the head of the list.
 * 
 * Example:
 * Input: 1->2->3
 * Output: 1->2->4
 * 
 * Leetcode: 369
 * https://leetcode.com/problems/plus-one-linked-list/
 * */
public class AddOneToIntAsLinkedList {
    public ListNode plusOne(ListNode head) {
        ListNode lastNotNine = head;
        ListNode ptr = head;
        while (ptr != null) {
            if (ptr.val != 9) {
                lastNotNine = ptr;
            }
            ptr = ptr.next;
        }
        return null;
    }
    
    public static void main(String[] args) {
        Util util = new Util();
        int []values = {1, 2, 3};
        ListNode head = util.makeList(values);
        AddOneToIntAsLinkedList obj = new AddOneToIntAsLinkedList();
        head = obj.plusOne(head);
        util.print(head);
    }
}
