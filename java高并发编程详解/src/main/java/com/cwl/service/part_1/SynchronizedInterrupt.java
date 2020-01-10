package com.cwl.service.part_1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/1913:43
 */
public class SynchronizedInterrupt implements Runnable {

    //Lock lock = new ReentrantLock();

    @Override
    public void run() {
        synchronized (this) {
            try {
                //lock.lockInterruptibly();
                //this.wait();
                TimeUnit.SECONDS.sleep(60);
            } catch (InterruptedException e) {
                System.out.println("throw exception...");
                e.printStackTrace();
            } finally {
                //if (lock != null) {
                //    lock.unlock();
                //}
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedInterrupt si = new SynchronizedInterrupt();
        Thread thread = new Thread(si, "T1");
        thread.start();
        TimeUnit.SECONDS.sleep(2);
        //thread.interrupt();
        Thread thread2 = new Thread(si, "T2");
        thread2.start();
        TimeUnit.SECONDS.sleep(1);
        thread2.interrupt();
        System.out.println(thread2);
        System.out.println(thread.isAlive());
    }

    private void method1() {
        synchronized (this) {

        }
    }

    Lock lock = new ReentrantLock();
    private void method2() {
        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
