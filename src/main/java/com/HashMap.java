package com;

import java.util.Arrays;

public class HashMap {

    private static final int FREE = Integer.MIN_VALUE;
    private int size;
    private int[] keys;
    private long[] values;

    public HashMap(int size) {
        this.size = Math.max(3 * size / 2, size) + 1;
        this.keys = new int[this.size];
        this.values = new long[this.size];
        Arrays.fill(keys, FREE);
    }

    public void put(int key, long value) {
        putNewValue(key, value);
    }

    public long get(int key) {
        return getValueByKey(key);
    }

    public int size() {
        return size;
    }


    private void putNewValue(int key, long value) {
        for (int i = index(hash(key)); ; i++) {
            if (i == size) i = 0;
            if (keys[i] == FREE)
                keys[i] = key;
            if (keys[i] == key) {
                values[i] = value;
                return;
            }
        }
    }

    private long getValueByKey(int key) {
        for (int i = index(hash(key)); ; i++) {
            if (i == size) i = 0;
            if (keys[i] == FREE)
                throw new RuntimeException("No such key!");
            if (keys[i] == key) return values[i];
        }
    }

    private int hash(int key) {
        return (key >> 15) ^ key;
    }

    private int index(int hash) {
        return Math.abs(hash) % size;
    }

//    private int step(int key) {
//        int simpleNumber = 5;
//        return simpleNumber - key % simpleNumber;
//    }

}
