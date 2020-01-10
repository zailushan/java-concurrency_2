package com.cwl.service.part_1.pool;

/**
 * @author cwl
 * @description: 创建线程的工厂
 * @date 2019/12/2010:49
 */
@FunctionalInterface
public interface ThreadFactory {

    Thread createThread(Runnable runnable);
}