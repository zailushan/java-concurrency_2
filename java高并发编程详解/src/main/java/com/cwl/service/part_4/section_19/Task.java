package com.cwl.service.part_4.section_19;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/299:46
 */
@FunctionalInterface
public interface Task<IN, OUT> {

    //给定一个参数，经过计算返回结果
    OUT get(IN input);
}