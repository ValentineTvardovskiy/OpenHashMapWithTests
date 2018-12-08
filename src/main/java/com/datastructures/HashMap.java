package com.datastructures;

public class HashMap {

    private static final int INITIAL_LENGTH = 16;
    private static final double LOAD_FACTOR = 1.25;

    private int capacity;
    private int size;
    private Pair[] pairs;

    public HashMap() {
        this.capacity = INITIAL_LENGTH;
        pairs = new Pair[INITIAL_LENGTH];
    }

    public void put(int key, long value) {
        Pair pair = new Pair(key, value);
        putPair(pair);
    }

    public long get(int key) {
        return getPair(key).value;
    }

    public int size() {
        return size;
    }

    private void putPair(Pair pair) {
        checkCurrentLength();

        int index = hash(pair.key);
        int step = step(pair.key);

        while (pairs[index] != null && pairs[index].key != pair.key) {
            index += step;
            index %= capacity;
        }
        pairs[index] = pair;
        size++;
    }

    private Pair getPair(int key) {
        int index = hash(key);
        int step = step(key);
        int count = size;

        while (pairs[index] != null) {
            if (pairs[index].key == key) {
                return pairs[index];
            }
            index += step;
            index %= capacity;

            count--;
            if (count == 0) break;
        }
        return null;
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
        capacity = capacity << 1;

        Pair[] newPairs = new Pair[capacity];

        for (Pair pair : pairs) {
            if (pair != null) {
                int index = hash(pair.key);
                int step = step(pair.key);

                while (newPairs[index] != null && newPairs[index].key != pair.key) {
                    index += step;
                    index %= capacity;
                }
                newPairs[index] = pair;
            }
        }
        pairs = newPairs;
    }

    class Pair {
        private int key;
        private long value;

        public Pair(int key, long value) {
            this.key = key;
            this.value = value;
        }
    }
}
