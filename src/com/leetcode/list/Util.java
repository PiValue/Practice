package com.leetcode.list;

public class Util<T> {
    public ListNode<T> makeList(T []array) {
        if (array == null || array.length == 0) {
            return null;
        }

        ListNode<T> prev = null;
        for (int index = array.length - 1; index >= 0; index--) {
            ListNode<T> head  = new ListNode<T>(array[index], prev);
            prev = head;
        }
        return prev;
    }

    public void print(ListNode<T> head) {
        while (head != null) {
            System.out.print(head.data.toString() + ", ");
            head = head.next;
        }
    }
}
