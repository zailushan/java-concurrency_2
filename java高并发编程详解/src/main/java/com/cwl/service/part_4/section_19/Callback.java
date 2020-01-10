package com.cwl.service.part_4.section_19;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/2914:32
 */
@FunctionalInterface
public interface Callback<T> {

    void call(T t);
}
