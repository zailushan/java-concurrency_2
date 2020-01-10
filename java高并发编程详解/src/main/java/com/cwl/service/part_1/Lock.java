package com.cwl.service.part_1;

import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/199:40
 */
public interface Lock {

    void lock() throws InterruptedException;

    void lock(long mills) throws InterruptedException, TimeoutException;

    void unlock();

    List<Thread> getBlockedThreads();
}
