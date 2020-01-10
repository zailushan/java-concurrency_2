package com.cwl.service.part_1;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/1614:59
 */
public class TryConcurrency {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                enjoyMusic();
            }
        });
        thread.start();
        browseNews();
    }

    private static void browseNews() {
        for (; ; ) {
            System.out.println("Uh-huh, the good news.");
            sleep(1);
        }
    }

    private static void enjoyMusic() {
        for (; ; ) {
            System.out.println("Uh-huh, the nice music.");
            sleep(1);
        }
    }

    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
