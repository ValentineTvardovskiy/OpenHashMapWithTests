package com;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashMapTest {

    private HashMap hashMap;

    @Before
    public void setUp() {
        hashMap = new HashMap();
        for (int i = 0; i < 5; i++) {
            hashMap.put(i, i);
        }
    }

    @Test
    public void testTrueSize() {
        int expectedResult = 5;
        Assert.assertEquals(expectedResult, hashMap.size());
    }

    @Test
    public void testGetByKey() {
        long expectedResult = 3;
        Assert.assertEquals(expectedResult, hashMap.get(3));
    }

    @Test(expected = RuntimeException.class)
    public void testGetByWrongKey() {
        int key = 55;
        hashMap.get(key);
    }

    @Test
    public void testPutSameKeyButAnotherValue() {
        long previousResult = hashMap.get(1);
        hashMap.put(1, 10);
        long newResult = hashMap.get(1);
        Assert.assertNotEquals(previousResult, newResult);
    }

    @Test
    public void testPutValueWithKeyBiggerThanCapacity() {
        hashMap.put(122, 123);
        long expectedResult = 123;
        Assert.assertEquals(expectedResult, hashMap.get(122));

    }

    @Test
    public void testPutAlreadyUsedIndexButAnotherKey() {
        long previousResult = hashMap.get(2);
        hashMap.put(18, 555);
        long expectedResult = hashMap.get(18);
        Assert.assertNotEquals(previousResult, expectedResult);
    }
}