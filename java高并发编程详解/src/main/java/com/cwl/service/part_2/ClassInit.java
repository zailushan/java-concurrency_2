package com.cwl.service.part_2;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/2316:08
 */
public class ClassInit {


    static {
        try {
            System.out.println("The ClassInit static code block will be invoke.");
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        IntStream.range(0, 5).forEach(i -> new Thread(ClassInit::new));
    }

}
