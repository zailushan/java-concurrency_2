package com.cwl.service.part_4.section_15;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/2614:49
 */
@FunctionalInterface
public interface Task<T> {

    //任务执行接口，该接口允许有返回值
    T call();
}
