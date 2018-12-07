package com.datastructures;

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
    public void testSize_shouldReturnProperSizeOfNonEmptyMap() {
        int expectedResult = 5;
        Assert.assertEquals(expectedResult, hashMap.size());
    }

    @Test
    public void testGetByKey_shouldReturnProperValue() {
        long expectedResult = 3;
        Assert.assertEquals(expectedResult, hashMap.get(3));
    }

    @Test(expected = RuntimeException.class)
    public void testGetByKeyNegativeScenario_shouldNotFoundKey() {
        int key = 55;
        hashMap.get(key);
    }

    @Test
    public void testPutSameKeyButAnotherValue_shouldRewriteValueForThisKey() {
        long previousResult = hashMap.get(1);
        hashMap.put(1, 10);
        long newResult = hashMap.get(1);
        Assert.assertNotEquals(previousResult, newResult);
    }

    @Test
    public void testPutValueWithKeyBiggerThanCapacity_shouldSimplyPutInFreePosition() {
        hashMap.put(122, 123);
        long expectedResult = 123;
        Assert.assertEquals(expectedResult, hashMap.get(122));

    }

    @Test
    public void testPutAlreadyUsedIndexButAnotherKey_shouldSimplyPutInFreePosition() {
        long previousResult = hashMap.get(2);
        hashMap.put(18, 555);
        long expectedResult = hashMap.get(18);
        Assert.assertNotEquals(previousResult, expectedResult);
    }
}