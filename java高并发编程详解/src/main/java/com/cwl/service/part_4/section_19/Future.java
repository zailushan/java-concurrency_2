package com.cwl.service.part_4.section_19;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/299:40
 */
public interface Future<T> {

    //返回计算后的结果，该方法会陷入阻塞状态
    T get() throws InterruptedException;

    //判断任务是否已经被执行完
    boolean done();
}
