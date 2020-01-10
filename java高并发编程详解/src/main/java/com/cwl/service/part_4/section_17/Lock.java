package com.cwl.service.part_4.section_17;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/279:41
 */
public interface Lock {

    //获取显式锁，没有获得锁的线程将被阻塞
    void lock() throws InterruptedException;

    //释放获取的锁
    void unlock();
}