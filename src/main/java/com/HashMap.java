package com;

import java.util.Arrays;

public class HashMap {

    private static final int FREE = Integer.MIN_VALUE;
    private static final int INITIAL_LENGTH = 16;
    private static final double LOAD_FACTOR = 1.25;

    private int capacity;
    private int size = 0;
    private int[] keys;
    private long[] values;

    public HashMap() {
        this.capacity = INITIAL_LENGTH;
        this.keys = new int[INITIAL_LENGTH];
        this.values = new long[INITIAL_LENGTH];

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
        checkCurrentLength();

        int index = hash(key);
        int step = step(key);

        while (keys[index] != FREE && keys[index] != key) {
            index += step;
            index %= capacity;
        }
        keys[index] = key;
        values[index] = value;
        size++;
    }

    private long getValueByKey(int key) {
        int index = hash(key);
        int step = step(key);
        int count = size;

        while (keys[index] != FREE) {
            if (keys[index] == key) {
                return values[index];
            }
            index += step;
            index %= capacity;

            count--;
            if (count == 0) break;
        }
        throw new RuntimeException("Not found");
    }

    private int hash(int key) {
        return key % capacity;
    }

    private int step(int key) {
        int simpleNumber = 5;
        return simpleNumber - key % simpleNumber;
    }

    private void checkCurrentLength() {
        if (size * LOAD_FACTOR >= capacity) {
            increaseLength();
        }
    }

    private void increaseLength() {
        capacity = capacity * 2;

        int[] newKeysArray = new int[capacity];
        long[] newValuesArray = new long[capacity];

        Arrays.fill(newKeysArray, FREE);
        Arrays.fill(newValuesArray, FREE);

        for (int i = 0; i < keys.length; i++) {
            int index = hash(keys[i]);
            int step = step(keys[i]);

            while (newKeysArray[index] != FREE && newKeysArray[index] != keys[i]) {
                index += step;
                index %= capacity;
            }
            newKeysArray[index] = keys[i];
            newValuesArray[index] = values[i];
        }

        keys = newKeysArray;
        values = newValuesArray;
    }

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();

        for (int i = 0; i < 10; i++) {
            hashMap.put(i, i);
            System.out.println(hashMap.get(i));
            System.out.println("Size: " + hashMap.size);
        }
        System.out.println();

        //add same key but another value
        System.out.println(hashMap.get(1));
        hashMap.put(1, 10);
        System.out.println("Looking for 10 number:" + hashMap.get(1));
        System.out.println("Size: " + hashMap.size);

        System.out.println();
        //add value with big key
        hashMap.put(115, 123);
        System.out.println("Looking for 123 number:" + hashMap.get(115));
        System.out.println("Size: " + hashMap.size);

        System.out.println("All values: ");
        for (int i = 0; i < hashMap.capacity; i++) {
            System.out.print("Key: " + hashMap.keys[i] + " and ");
            System.out.println("Value: " + hashMap.values[i]);
        }


        System.out.println();
        //add already used index but another key
        hashMap.put(11, 555);
        System.out.println("Looking for 555 number:" + hashMap.get(11));
        System.out.println("Size: " + hashMap.size);

        System.out.println("All values: ");
        for (int i = 0; i < hashMap.capacity; i++) {
            System.out.print("Key: " + hashMap.keys[i] + " and ");
            System.out.println("Value: " + hashMap.values[i]);
        }
        System.out.println("Size: " + hashMap.size);

        System.out.println();
        //add already used index but another key
        hashMap.put(107, 666);
        System.out.println("Looking for 666 number:" + hashMap.get(107));

        System.out.println("All values: ");
        for (int i = 0; i < hashMap.capacity; i++) {
            System.out.print("Key: " + hashMap.keys[i] + " and ");
            System.out.println("Value: " + hashMap.values[i]);
        }

//        System.out.println();
//        System.out.println(hashMap.get(116));
    }

}
