package com.sam09.Exercises.Hashing;

public class Hash {
    private int hash;
    private int bucket;
    private int hashCode;
    private static final int DEFAULT_BUCKET_SIZE = 16;

    //To prevent from being used
    private Hash() {}

    public Hash(Object obj) {
        hashCode = obj.hashCode();
        bucket = DEFAULT_BUCKET_SIZE;
        hash = hashCode ^ (hashCode >>> bucket);
    }

    public Hash(Object obj, int n) {
        bucket = n;
        hashCode = obj.hashCode();
        hash = hashCode ^ (hashCode >>> bucket);
    }

    public int getBucket() {
        return ((bucket - 1) & hash);
    }

    public String getBinary(int value) {
        return Integer.toBinaryString(value);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hash hash = (Hash) o;
        return hashCode == hash.hashCode;
    }
}
