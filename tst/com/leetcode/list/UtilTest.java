package com.leetcode.list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UtilTest {
    private Util<Integer> util = null;
    
    @Before
    public void setup() {
        util = new Util<Integer>();
    }
    
    @Test
    public void testNull() {
        Assert.assertNull(util.makeList(null));
    }
    
    @Test
    public void testEmpty() {
        Integer []array = {};
        Assert.assertNull(util.makeList(array));
    }
    
    @Test
    public void testList() {
        Integer []array = {2, 43, 1, 43, 54, 11, 6, 76, 33};
        ListNode<Integer> list = util.makeList(array);
        int len = 0;
        while (list != null && len < array.length) {
            if (!list.data.equals(array[len])) {
                break;
            }
            list = list.next;
            len++;
        }
        Assert.assertTrue(list == null && len == array.length);
    }
}
