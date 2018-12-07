package com;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashMapTest {

    private HashMap hashMap;

    public void setUp() throws Exception {
        hashMap = new HashMap();
        for (int i = 0; i < 10; i++) {
            hashMap.put(i, i);
        }
    }

    @Test
    public void testTrueSize() {
    }

    @Test
    public void testGetByKey() {
    }

    @Test
    public void testGetByWrongKey() {
    }

    @Test
    public void testPutSameKeyButAnotherValue() {
    }

    @Test
    public void testPutValueWithBigKey() {
    }

    @Test
    public void testPutAlreadyUsedIndexButAnotherKey() {
    }
}