package com;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashMapTest {

    private HashMap hashMap;
    int size;

    @Before
    public void setUp() throws Exception {
        size = 10;
        hashMap = new HashMap(size);
        for (int i = 0; i < 10; i++)
        hashMap.put(i, i);
    }

    @Test
    public void testSize() {
        int expectedResult = 3 * size / 2 + 1;
        Assert.assertEquals(expectedResult, hashMap.size());
    }

    @Test
    public void testSizeIncrease() {
        for (int i = 10; i < 20; i++)
            hashMap.put(i, i);
        int expectedResult = (3 * size / 2 + 1) + 10;
        Assert.assertEquals(expectedResult, hashMap.size());
    }

    @Test
    public void testPutNewValue() {
    }

    @Test
    public void testGetByIndex() {
    }

    @Test
    public void testGetByWrongIndex() {
    }

}