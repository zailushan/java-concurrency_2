package com.cwl.service.part_4.section_23;

import java.util.concurrent.TimeUnit;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/3017:15
 */
public class TestMain {

    public static void main(String[] args) throws InterruptedException {
        //Latch latch = new CountDownLatch(4);
        //        //new ProgrammerTravel(latch, "Alex", "Bus").start();
        //        //new ProgrammerTravel(latch, "Gavin", "Walking").start();
        //        //new ProgrammerTravel(latch, "Jack", "Subway").start();
        //        //new ProgrammerTravel(latch, "Dillon", "Bicycle").start();
        //        //latch.await();
        //        //System.out.println("== all of programmer arrived ==");

        Latch latch = new CountDownLatch(4);
        new ProgrammerTravel(latch, "Alex", "Bus").start();
        new ProgrammerTravel(latch, "Gavin", "Walking").start();
        new ProgrammerTravel(latch, "Jack", "Subway").start();
        new ProgrammerTravel(latch, "Dillon", "Bicycle").start();
        try {
            latch.await(TimeUnit.SECONDS, 5);
            System.out.println("== all of programmer arrived ==");
        } catch (WaitTimeoutException e) {
            e.printStackTrace();
        }
    }
}
