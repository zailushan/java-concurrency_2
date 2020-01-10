package com.cwl.service.part_1;

import java.util.concurrent.TimeUnit;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/1715:20
 */
public class ThreadInterrupted {

    public static void main(String[] args) {
        System.out.println("Main thread is interrupted? " + Thread.interrupted());

        Thread.currentThread().interrupt();

        System.out.println("Main thread is interrupted? " + Thread.currentThread().isInterrupted());

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("test 1");
        }
        //再次打断
        Thread.currentThread().interrupt();
        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("I will be interrupted still.");
        }
    }
}
