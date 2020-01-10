package com.cwl.service.part_4.section_15;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/2614:36
 */
public interface Observable {

    enum Cycle {
        STARTED, RUNNING, DONE, ERROR
    }

    //获取当前任务的生命周期
    Cycle getCycle();

    //定义启动线程的方法，主要作用是为了屏蔽Thread的其它方法
    void start();

    //定义线程的打断方法，作用与start方法一样，也是为了屏蔽Thread的其他方法。
    void interrupt();

}
