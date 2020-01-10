package com.cwl.service.part_1;

import java.util.HashMap;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/1814:40
 */
public class HashMapDeadLock {

    private final HashMap<String, Object> map = new HashMap<>();

    private void add(String key, String value) {
        this.map.put(key, value);
    }

    public static void main(String[] args) {
        final HashMapDeadLock hashMapDeadLock = new HashMapDeadLock();
        for (int x = 0; x < 2; x++) new Thread(() -> {
            for (int i = 1; i < Integer.MAX_VALUE; i++) {
                hashMapDeadLock.add(String.valueOf(i), String.valueOf(i));
            }
        }).start();
    }
}
