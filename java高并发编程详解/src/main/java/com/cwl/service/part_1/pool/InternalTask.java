package com.cwl.service.part_1.pool;

/**
 * @author cwl
 * @description: 负责从任务队列中获取任务并执行
 * @date 2019/12/2011:04
 */
public class InternalTask implements Runnable {

    private final RunnableQueue runnableQueue;

    private volatile boolean running = true;

    public InternalTask(RunnableQueue runnableQueue) {
        this.runnableQueue = runnableQueue;
    }

    @Override
    public void run() {
        //如果当前任务为running并且没有中断，则其将不断地从queue中获取running，然后执行run方法
        while (running && !Thread.currentThread().isInterrupted()) {
            try {
                Runnable task = runnableQueue.take();
                task.run();
            } catch (Exception e) {
                running = false;
                break;
            }
        }
    }

    //停止当前任务，主要会在线程池的shutdown方法中使用
    public void stop() {
        this.running = false;
    }
}
