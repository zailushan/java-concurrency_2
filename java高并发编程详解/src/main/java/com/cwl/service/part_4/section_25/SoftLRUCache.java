package com.cwl.service.part_4.section_25;

import sun.misc.GC;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author cwl
 * @description: TODO
 * @date 2020/1/210:02
 */
public class SoftLRUCache<K, V> {

    private final LinkedList<K> keyList = new LinkedList<>();

    private final Map<K, SoftReference<V>> cache = new HashMap<>();

    private final int capacity;

    private final CacheLoader<K, V> cacheLoader;

    public SoftLRUCache(int capacity, CacheLoader<K, V> cacheLoader) {
        this.capacity = capacity;
        this.cacheLoader = cacheLoader;
    }

    public void put(K key, V value) {
        //当元素数量超过容量时，将最老的(最近最少使用)的数据清除掉
        if (keyList.size() >= capacity) {
            K eldestKey = keyList.removeFirst();
            cache.remove(eldestKey);
        }
        //如果数据已经存在，则从key的队列中删除
        if (keyList.contains(key)) {
            keyList.remove(key);
        }
        //将key存放值队尾
        keyList.addLast(key);
        cache.put(key, new SoftReference<>(value));
    }

    public V get(K key) {
        V value;
        boolean success = keyList.remove(key);
        if (!success) {
            value = cacheLoader.load(key);
            this.put(key, value);
        } else {
            value = cache.get(key).get();
            keyList.addLast(key);
        }
        return value;
    }

    @Override
    public String toString() {
        return this.keyList.toString();
    }

    //测试
    public static void main(String[] args) throws InterruptedException {
        SoftLRUCache<Integer, Reference> cache = new SoftLRUCache<>(10000, key -> new Reference());
        System.out.println(cache);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            cache.get(i);
            TimeUnit.MILLISECONDS.sleep(10);
            System.out.println("The " + i + " reference stored at cache.");
        }

    }
}
