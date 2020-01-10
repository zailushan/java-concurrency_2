package com.cwl.service.part_1;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/1814:50
 */
public class DeadLock {

    private final Object MUTEX_READ = new Object();
    private final Object MUTEX_WRITE = new Object();

    private void read() {
        synchronized (MUTEX_READ) {
            System.out.println(Thread.currentThread().getName() + " get READ lock");
            synchronized (MUTEX_WRITE) {
                System.out.println(Thread.currentThread().getName() + " get WRITE lock");
            }
            System.out.println(Thread.currentThread().getName() + " release WRITE lock");
        }
        System.out.println(Thread.currentThread().getName() + " release READ lock");
    }

    private void write() {
        synchronized (MUTEX_WRITE) {
            System.out.println(Thread.currentThread().getName() + " get WRITE lock");
            synchronized (MUTEX_READ) {
                System.out.println(Thread.currentThread().getName() + " get READ lock");
            }
            System.out.println(Thread.currentThread().getName() + " release READ lock");
        }
        System.out.println(Thread.currentThread().getName() + " release WRITE lock");
    }

    public static void main(String[] args) {
        final DeadLock deadLock = new DeadLock();
        new Thread(() -> {
            while (true) {
                deadLock.read();
            }
        }, "READ-Thread").start();

        new Thread(() -> {
            while (true) {
                deadLock.write();
            }
        }, "WRITE-Thread").start();
    }
}
