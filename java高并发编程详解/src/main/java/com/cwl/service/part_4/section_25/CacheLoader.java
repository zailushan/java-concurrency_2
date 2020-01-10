package com.cwl.service.part_4.section_25;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/3116:55
 */
@FunctionalInterface
public interface CacheLoader<K, V> {

    V load(K k);
}
