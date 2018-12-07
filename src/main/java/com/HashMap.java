package com;

import java.util.Arrays;

public class HashMap {

    private static final int FREE = Integer.MIN_VALUE;

    private int size;
    private int[] keys;
    private long[] values;

    public HashMap(int size) {
        this.size = size;
        this.keys = new int[this.size];
        this.values = new long[this.size];

        Arrays.fill(keys, FREE);
        Arrays.fill(values, FREE);
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
        int index = hash(key);
        int step = step(key);

        while (keys[index] != FREE && keys[index] != key) {
            index += step;
            index %= size;
        }
        keys[index] = key;
        values[index] = value;
    }

    private long getValueByKey(int key) {
        int index = hash(key);
        int step = step(key);
        int count = size;

        while (keys[index] != FREE) {
            if (keys[index] == key) return values[index];
            index += step;
            index %= size;

            count--;
            if (count == 0) break;
        }
        throw new RuntimeException("Not found");
    }

    private int hash(int key) {
        return key % size;
    }

    private int step(int key) {
        int simpleNumber = 5;
        return simpleNumber - key % simpleNumber;
    }


    public static void main(String[] args) {
        HashMap hashMap = new HashMap(13);

        for (int i = 0; i < 10; i++) {
            hashMap.put(i, i);
            System.out.println(hashMap.get(i));
        }
        System.out.println();

        //add same key but another value
        System.out.println(hashMap.get(1));
        hashMap.put(1, 10);
        System.out.println(hashMap.get(1));

        System.out.println();
        //add value with big key
        hashMap.put(115, 123);
        System.out.println(hashMap.get(115));

        System.out.println("All values: ");
        for (int i = 0; i < hashMap.size; i++) {
            System.out.println(hashMap.values[i]);
        }

        System.out.println();
        //add already used index but another key
        hashMap.put(11, 555);
        System.out.println(hashMap.get(11));

        System.out.println("All values: ");
        for (int i = 0; i < hashMap.size; i++) {
            System.out.println(hashMap.values[i]);
        }

        System.out.println();
        //add already used index but another key
        hashMap.put(107, 666);
        System.out.println(hashMap.get(107));

        System.out.println("All values: ");
        for (int i = 0; i < hashMap.size; i++) {
            System.out.println(hashMap.values[i]);
        }

        System.out.println();
        System.out.println(hashMap.get(116));
    }

}
