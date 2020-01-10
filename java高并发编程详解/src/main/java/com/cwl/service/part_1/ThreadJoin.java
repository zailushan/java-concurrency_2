package com.cwl.service.part_1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/1717:37
 */
public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = create(1);
        Thread thread2 = create(1);

        List<Thread> list = new ArrayList<>();
        list.add(thread1);
        list.add(thread2);

        for (Thread thread : list) {
            thread.start();
        }
        //for (Thread thread : list) {
        //    thread.join();
        //}
        thread1.join();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "#" + i);
            shortSleep();
        }

    }

    private static Thread create(int seq) {
        return new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "#" + i);
                shortSleep();
            }
        });
    }

    private static void shortSleep() {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
