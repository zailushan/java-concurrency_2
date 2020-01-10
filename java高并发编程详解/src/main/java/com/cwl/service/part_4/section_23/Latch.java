package com.cwl.service.part_4.section_23;

import java.util.concurrent.TimeUnit;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/3016:55
 */
public abstract class Latch {

    protected int limit;

    public Latch(int limit) {
        this.limit = limit;
    }

    public abstract void await() throws InterruptedException;

    //可超时的等待
    public abstract void await(TimeUnit unit, long time) throws InterruptedException, WaitTimeoutException;

    public abstract void countDown();

    public abstract int getUnarrived();
}
