package com.cwl.service.part_4.section_27;

/**
 * @author cwl
 * @description: TODO
 * @date 2020/1/316:43
 */
public class ActiveDaemonThread extends Thread {

    private final ActiveMessageQueue queue;

    public ActiveDaemonThread(ActiveMessageQueue queue) {
        super("ActiveDaemonThread");
        this.queue = queue;
        //ActiveDaemonThread为守护线程
        setDaemon(true);
    }

    @Override
    public void run() {
        for (; ; ) {
            //从MethodMessage队列中获取一个MethodMessage,然后执行execute方法
            MethodMessage methodMessage = this.queue.take();
            methodMessage.execute();
        }
    }
}
