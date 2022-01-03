package com.sks.leatcode.common;

public class CustomPair<K, V> implements Comparable<CustomPair> {
    public K key;
    public V value;

    public CustomPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(CustomPair pair) {
        if (key instanceof Integer && value instanceof Integer)
            return this.value == pair.value ? Integer.compare((Integer) this.key, (Integer) pair.key) : Integer.compare((Integer) this.value, (Integer) pair.value);
        else if (value instanceof Integer)
            return Integer.compare((Integer) this.value, (Integer) pair.value);
        else throw new UnsupportedOperationException("This comparison is not-Supported");
    }

    @Override
    public String toString() {
        return "CustomPair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
