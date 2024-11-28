package hashmap;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *  A hash table-backed Map implementation. Provides amortized constant time
 *  access to elements via get(), remove(), and put() in the best case.
 *
 *  Assumes null keys will never be inserted, and does not resize down upon remove().
 *  @author YOUR NAME HERE
 */
public class MyHashMap<K, V> implements Map61B<K, V> {

    @Override
    public void clear() {
        buckets = createTable(this.size);
        keys.clear();
        items = 0;
    }

    @Override
    public boolean containsKey(K key) {
        for (int i = 0; i < size; i++) {
            Collection<Node> chain = buckets[i];
            Iterator<Node> iterator = chain.iterator();
            while (iterator.hasNext()) {
                Node next = iterator.next();
                if (next.key.equals(key)) {
                    return true;
                }
            }

        }
        return false;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            Collection<Node> chain = buckets[i];
            Iterator<Node> iterator = chain.iterator();
            while (iterator.hasNext()) {
                Node next = iterator.next();
                if (next.key.equals(key)) {
                    return next.value;
                }
            }

        }
        return null;
    }

    @Override
    public int size() {
        return items;
    }

    @Override
    public void put(K key, V value) {
        //当不需要扩展容量
        keys.add(key);
        items = items + put(createNode(key, value), buckets, this.size);
        //然后是需要扩展容量的时候
        if (items / this.size > this.maxLoad) {
            Collection<Node>[] newBucket = createTable(this.size * 2);
            for (int i = 0; i < this.size; i++) {
                Iterator<Node> iterator = buckets[i].iterator();
                while (iterator.hasNext()) {
                    Node next = iterator.next();
                    put(next, newBucket, this.size * 2);
                }
            }
            buckets = newBucket;
            this.size *= 2;
        }


    }
    private int put(Node node, Collection<Node>[] buckets, int size) {
        int hashCode = node.key.hashCode();
        while (hashCode < 0) {
            hashCode += size;
        }
        Collection<Node> bucket = buckets[hashCode % size];
        Iterator<Node> iterator = bucket.iterator();
        while (iterator.hasNext()) {
            Node next = iterator.next();
            if (next.key.equals(node.key)) {
                next.value = node.value;
                return 0;
            }
        }
        bucket.add(node);
        return 1;
    }

    @Override
    public Set<K> keySet() {
        return keys;

    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        return keys.iterator();
    }

    /**
     * Protected helper class to store key/value pairs
     * The protected qualifier allows subclass access
     */
    protected class Node {
        K key;
        V value;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    /* Instance Variables */
    private Collection<Node>[] buckets;
    private int size;
    private HashSet<K> keys;
    private int items;
    private double maxLoad;
    // You should probably define some more!

    /** Constructors */
    public MyHashMap() {
        this(16, 0.75);
    }

    public MyHashMap(int initialSize) {
        this(initialSize, 0.75);
    }

    /**
     * MyHashMap constructor that creates a backing array of initialSize.
     * The load factor (# items / # buckets) should always be <= loadFactor
     *
     * @param initialSize initial size of backing array
     * @param maxLoad maximum load factor
     */
    public MyHashMap(int initialSize, double maxLoad) {
        this.size = initialSize;
        this.maxLoad = maxLoad;

        buckets = createTable(this.size);
        keys = new HashSet<>();
        items = 0;
    }

    /**
     * Returns a new node to be placed in a hash table bucket
     */
    private Node createNode(K key, V value) {
        return new Node(key, value);
    }

    /**
     * Returns a data structure to be a hash table bucket
     *
     * The only requirements of a hash table bucket are that we can:
     *  1. Insert items (`add` method)
     *  2. Remove items (`remove` method)
     *  3. Iterate through items (`iterator` method)
     *
     * Each of these methods is supported by java.util.Collection,
     * Most data structures in Java inherit from Collection, so we
     * can use almost any data structure as our buckets.
     *
     * Override this method to use different data structures as
     * the underlying bucket type
     *
     * BE SURE TO CALL THIS FACTORY METHOD INSTEAD OF CREATING YOUR
     * OWN BUCKET DATA STRUCTURES WITH THE NEW OPERATOR!
     */
    protected Collection<Node> createBucket() {
        return new HashSet<>();
    }

    /**
     * Returns a table to back our hash table. As per the comment
     * above, this table can be an array of Collection objects
     *
     * BE SURE TO CALL THIS FACTORY METHOD WHEN CREATING A TABLE SO
     * THAT ALL BUCKET TYPES ARE OF JAVA.UTIL.COLLECTION
     *
     * @param tableSize the size of the table to create
     */
    private Collection<Node>[] createTable(int tableSize) {
        Collection<Node>[] table = new Collection[tableSize];
        for (int i = 0; i < tableSize; i++) {
            table[i] = createBucket();
        }
        return table;
    }


    // Your code won't compile until you do so!

}
