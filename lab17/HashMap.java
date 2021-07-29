import java.lang.reflect.Array;
import java.util.Iterator;

import java.lang.Math;

public class HashMap<K, V> implements Map61BL<K, V> {

    private class BucketNode {

        public K key;
        public V value;
        public BucketNode next;

        public BucketNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private double maxLoadFactor;
    private BucketNode[] buckets;
    private int size;


    public HashMap() {
        this(10, 2);
    }

    public HashMap(int initialCapacity) {
        this(initialCapacity, 2);
    }

    public HashMap(int initialCapacity, double loadFactor) {
        buckets = (BucketNode[]) Array.newInstance(BucketNode.class, initialCapacity);
        maxLoadFactor = loadFactor;
        clear();
    }

    @Override
    public void clear() {
        buckets = (BucketNode[]) Array.newInstance(BucketNode.class, buckets.length);
        size = 0;

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new BucketNode(null, null);
        }
    }

    private int getBucket(int hashCode) {
        return Math.floorMod(hashCode, buckets.length);
    }

    @Override
    public boolean containsKey(K key) {
        BucketNode bucket = buckets[getBucket(key.hashCode())];

        while (bucket.next != null) {
            bucket = bucket.next;

            if (key.equals(bucket.key)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public V get(K key) {

        BucketNode bucket = buckets[getBucket(key.hashCode())];

        while (bucket.next != null) {
            bucket = bucket.next;

            if (key.equals(bucket.key)) {
                return bucket.value;
            }
        }

        return null;
    }

    @Override
    public void put(K key, V value) {

        BucketNode bucket = buckets[getBucket(key.hashCode())];

        while (bucket.next != null) {
            bucket = bucket.next;

            if (key.equals(bucket.key)) {
                bucket.value = value;
                return;
            }
        }

        bucket.next = new BucketNode(key, value);
        size += 1;
    }

    @Override
    public V remove(K key) {

        BucketNode bucket = buckets[getBucket(key.hashCode())];

        while (bucket.next != null) {
            if (key.equals(bucket.next.key)) {
                V value = bucket.next.value;
                bucket.next = bucket.next.next;
                size -= 1;
                return value;
            }
        }

        return null;
    }

    @Override
    public boolean remove(K key, V value) {
        BucketNode bucket = buckets[getBucket(key.hashCode())];

        while (bucket.next != null) {
            if (key.equals(bucket.next.key)) {
                if (value.equals(bucket.next.value)) {
                    bucket.next = bucket.next.next;
                    size -= 1;
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    public int capacity() {
        return buckets.length;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }
}
