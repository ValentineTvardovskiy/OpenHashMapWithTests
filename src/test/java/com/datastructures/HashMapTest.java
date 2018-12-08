package com.datastructures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HashMapTest {

    private HashMap hashMap;

    @Before
    public void setUp() {
        hashMap = new HashMap();
    }

    @Test
    public void testSize_shouldReturnProperSizeOfNonEmptyMap() {
        for (int i = 0; i < 30; i++) {
            hashMap.put(i, i);
        }
        int expectedResult = 30;
        Assert.assertEquals(expectedResult, hashMap.size());
    }

    @Test
    public void testGetByKey_shouldReturnProperValue() {
        hashMap.put(2, 22);
        hashMap.put(3, 33);
        long expectedResult = 33;
        Assert.assertEquals(expectedResult, hashMap.get(3));
    }

    @Test(expected = NullPointerException.class)
    public void testGetByKeyNegativeScenario_shouldReturnNull() {
        for (int i = 0; i < 5; i++) {
            hashMap.put(i, i);
        }
        int key = 55;
        hashMap.get(key);
    }

    @Test
    public void testPutSameKeyButAnotherValue_shouldRewriteValueForThisKey() {
        hashMap.put(1, 11);
        long previousResult = hashMap.get(1);
        hashMap.put(1, 10);
        long newResult = hashMap.get(1);
        Assert.assertNotEquals(previousResult, newResult);
    }

    @Test
    public void testPutValueWithKeyBiggerThanInitialCapacity_shouldSimplyPutInFreePosition() {
        hashMap.put(122, 123);
        long expectedResult = 123;
        Assert.assertEquals(expectedResult, hashMap.get(122));

    }

    @Test
    public void testPutAlreadyUsedIndexButAnotherKey_shouldSimplyPutInFreePosition() {
        hashMap.put(2, 22);
        long previousResult = hashMap.get(2);
        hashMap.put(18, 555);
        long expectedResult = hashMap.get(18);
        Assert.assertNotEquals(previousResult, expectedResult);
    }
}