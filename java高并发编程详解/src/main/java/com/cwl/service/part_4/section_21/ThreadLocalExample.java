package com.cwl.service.part_4.section_21;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/3013:29
 */
public class ThreadLocalExample {

    public static void main(String[] args) {
        ThreadLocal<Integer> tlocal = new ThreadLocal<>();

        IntStream.range(0, 10).forEach(i -> new Thread(() -> {
            try {
                tlocal.set(i);
                System.out.println(Thread.currentThread() + " set i" + tlocal.get());
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread() + " get i" + tlocal.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start());
    }
}
