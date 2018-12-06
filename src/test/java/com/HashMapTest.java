package com;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashMapTest {

    private HashMap hashMap;

    @Before
    public void setUp() throws Exception {
        hashMap = new HashMap(10);
        for (int i = 0; i < 10; i++)
        hashMap.put(i, i);
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

    @Test
    public void testSize() {
    }

    @Test
    public void testSizeIncrease() {
    }
}