package com.cwl.service.part_4.section_25;

import java.util.concurrent.TimeUnit;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/3117:04
 */
public class TestMain {

    public static void main(String[] args) throws InterruptedException {
        //LRUCache<String, Reference> cache = new LRUCache<>(5, key -> new Reference());
        //cache.get("Alex");
        //cache.get("Jack");
        //cache.get("Gavin");
        //cache.get("Dillon");
        //cache.get("Leo");
        ////上面的数据在缓存中的新旧程度为Leo>Dillon>Gavin>Jack>Alex
        //
        //cache.get("Jenny");//Alex将被踢出
        //System.out.println(cache.toString());

        LRUCache<Integer, Reference> cache = new LRUCache<>(10000, key -> new Reference());
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            cache.get(i);
            TimeUnit.MILLISECONDS.sleep(10);
            System.out.println("The " + i + " reference stored at cache.");
        }
        
    }
}
