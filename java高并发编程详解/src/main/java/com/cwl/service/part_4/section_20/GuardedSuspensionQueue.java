package com.cwl.service.part_4.section_20;

import javax.xml.crypto.Data;
import java.util.LinkedList;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/309:03
 */
public class GuardedSuspensionQueue {
    //定义存放Integer类型的queue
    private final LinkedList<Integer> queue = new LinkedList<>();

    //定义queue的最大容量为100
    private final int LIMIT = 100;

    //往queue中插入数据，如果queue中的元素超过了最大容量，则会陷入阻塞
    public void offer(Integer data) throws InterruptedException {
        synchronized (this) {
            //判断queue的当前元素是否超过了LIMIT
            while (queue.size() >= LIMIT) {
                //挂起当前线程，使其陷入阻塞
                this.wait();
            }
            //插入元素并且唤醒take线程
            queue.addLast(data);
            this.notifyAll();
        }
    }

    //从队列中获取元素，如果队列此时为空 则会陷入阻塞
    public Integer take() throws InterruptedException {
        synchronized (this) {
            //判断队列如果为空
            while (queue.isEmpty()) {
                //则挂起当前线程
                this.wait();
            }
            //通知offer线程可以继续插入数据了
            this.notify();
            return queue.removeFirst();
        }
    }
}
