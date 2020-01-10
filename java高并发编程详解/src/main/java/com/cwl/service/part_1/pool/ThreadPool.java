package com.cwl.service.part_1.pool;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/2010:35
 */
public interface ThreadPool {

    //提交任务到线程池
    void execute(Runnable runnable);

    //关闭线程池
    void shutdown();

    //获取线程池初始化大小
    int getInitSize();

    //获取线程池的最大线程数量
    int getMaxSize();

    //获取线程池中核心线程数量
    int getCoreSize();

    //获取线程池中用于缓存任务队列的大小
    int getQueueSize();

    //获取线程池中活跃的线程数量
    int getActiveCount();

    //查看线程池是否已经关闭
    boolean isShutdown();
}