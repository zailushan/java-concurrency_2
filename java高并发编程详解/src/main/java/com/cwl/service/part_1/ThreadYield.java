package com.cwl.service.part_1;

import java.util.stream.IntStream;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/1714:31
 */
public class ThreadYield {

    public static void main(String[] args) {
        IntStream.range(0,2).mapToObj(ThreadYield::create).forEach(Thread::start);
    }

    private static Thread create(int index) {
        return new Thread(() -> {
            if (index == 0) {
                Thread.yield();
            }
            System.out.println(index);
        });
    }


}
