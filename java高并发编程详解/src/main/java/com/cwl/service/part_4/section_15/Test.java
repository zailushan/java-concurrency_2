package com.cwl.service.part_4.section_15;

import java.util.concurrent.TimeUnit;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/2615:17
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        Observable observable = new ObservableThread<>(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" finish done.");
            return "hello";
        });
        observable.start();
        //TimeUnit.SECONDS.sleep(1);
        //System.out.println(observable.getCycle());
    }
}
