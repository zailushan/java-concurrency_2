package com.cwl.service.part_1;

import java.util.concurrent.TimeUnit;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/1715:33
 */
public class ThreadIsInterrupted {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(){
            @Override
            public void run() {
                while (true) {
                    //todo
                }
            }
        };
        thread.start();
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.printf("Thread is interrupt ? %s\n", thread.isInterrupted());
        thread.interrupt();
        System.out.printf("Thread is interrupt ? %s\n", thread.isInterrupted());
    }
}
