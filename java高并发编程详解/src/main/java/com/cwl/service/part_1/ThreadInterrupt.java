package com.cwl.service.part_1;

import java.util.concurrent.TimeUnit;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/1715:20
 */
public class ThreadInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("Oh, i am be interrupted.");
            }
        });
        thread.start();
        TimeUnit.MILLISECONDS.sleep(2);
        thread.interrupt();
    }
}
