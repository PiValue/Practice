package com.leetcode.list;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UtilTest {
    private Util util = null;

    @Before
    public void setup() {
        util = new Util();
    }

    @Test
    public void testNull() {
        Assert.assertNull(util.makeList(null));
    }

    @Test
    public void testEmpty() {
        int []array = {};
        Assert.assertNull(util.makeList(array));
    }

    @Test
    public void testList() {
        int []array = {2, 43, 1, 43, 54, 11, 6, 76, 33};
        ListNode list = util.makeList(array);
        int len = 0;
        while (list != null && len < array.length) {
            if (list.val != array[len]) {
                break;
            }
            list = list.next;
            len++;
        }
        Assert.assertTrue(list == null && len == array.length);
    }

    @Test
    public void testListLen() {
        int []array = {2, 4, 3, 5, 4, 7, 6, 7};
        ListNode head = util.makeList(array);
        Assert.assertEquals(array.length, util.listLen(head));
    }
    
    @Test
    public void testToSet() {
        int []array = {2, 4, 3, 5, 4, 7, 6, 7};
        ListNode head = util.makeList(array);
        
        Set<Integer> values = new HashSet<Integer>();
        for (int value : array) {
            values.add(value);
        }
        Assert.assertEquals(values, util.toSet(head));
    }
}
