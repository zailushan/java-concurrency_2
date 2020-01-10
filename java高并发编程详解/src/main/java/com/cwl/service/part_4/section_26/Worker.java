package com.cwl.service.part_4.section_26;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author cwl
 * @description: TODO
 * @date 2020/1/310:09
 */
public class Worker extends Thread {

    private final ProductionChannel channel;

    private final static Random random = new Random(System.currentTimeMillis());

    public Worker(String workerName, ProductionChannel channel) {
        super(workerName);
        this.channel = channel;
    }

    @Override
    public void run() {
        while (true) {
            Production production = channel.taskProduction();
            System.out.println(getName() + " process the " + production);
            production.create();
            try {
                TimeUnit.SECONDS.sleep(random.nextInt());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
