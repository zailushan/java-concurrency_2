package com.cwl.service.part_4.section_27;

import java.util.LinkedList;

/**
 * @author cwl
 * @description: TODO
 * @date 2020/1/314:01
 */
public class ActiveMessageQueue {

    //用于存放提交的MethodMessage消息
    private final LinkedList<MethodMessage> messages = new LinkedList<>();

    public ActiveMessageQueue() {
        //启动Worker线程
        new ActiveDaemonThread(this).start();
    }

    public void offer(MethodMessage methodMessage) {
        synchronized (this) {
            messages.addLast(methodMessage);
            //因为只有一个线程负责take数据，因此没有必要使用notifyAll方法
            this.notify();
        }
    }

    protected MethodMessage take() {
        synchronized (this) {
            //当MethodMessage队列中没有Message的时候，执行线程进入阻塞
            while (messages.isEmpty()) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //获取其中一个MethodMessage并且从队列中移除
            return messages.removeFirst();
        }
    }
}
