package com.ctci.list;

import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.leetcode.list.ListNode;
import com.leetcode.list.Util;

public class RemoveDuplicatesTest {
    private RemoveDuplicates obj = null;
    private Util util = new Util();
    
    @Before
    public void setup() {
        this.obj = new RemoveDuplicates();
    }
    
    @After
    public void teardown() {
        this.obj = null;
    }
    
    
    @Test
    public void testNull() {
        ListNode head = obj.removeDuplicates(null);
        Assert.assertNull(head);
    }
    
    @Test
    public void testSingleNode() {
        ListNode head = util.makeList(new int[] {42});
        ListNode newHead = obj.removeDuplicates(head);
        Assert.assertEquals(util.listLen(head), util.listLen(newHead));
    }
    
    @Test
    public void testNoDuplicates() {
        ListNode head = util.makeList(new int[] {7, 2, 5, 1, 8, 9, 10, 3});
        ListNode newHead = obj.removeDuplicates(head);
        Assert.assertEquals(util.listLen(head), util.listLen(newHead));
    }
    
    @Test
    public void testAllDuplicates() {
        ListNode head = util.makeList(new int[] {4, 4, 4, 4, 4, 4, 4, 4, 4});
        int origLen = util.listLen(head);

        ListNode newHead = obj.removeDuplicates(head);
        Assert.assertNotEquals(origLen, util.listLen(newHead));
        Assert.assertEquals(1, util.listLen(newHead));
    }
    
    @Test
    public void testWithValues() {
        ListNode head = util.makeList(new int[] {1, 2, 1, 3, 4, 4, 0, 6, 1, 7, 8});
        int origLen = util.listLen(head);
        
        ListNode newHead = obj.removeDuplicates(head);
        
        Set<Integer> origValues = util.toSet(head);
        Set<Integer> newValues = util.toSet(newHead);
        
        Assert.assertEquals(origValues, newValues);
        Assert.assertEquals(newValues.size(), util.listLen(newHead));
        Assert.assertNotEquals(origLen, util.listLen(newHead));
    }
}
