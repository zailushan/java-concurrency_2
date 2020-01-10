package com.cwl.service.part_4.section_19;

import java.util.concurrent.TimeUnit;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/2913:44
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        //没有返回值
        //FutureService<Void, Void> service = FutureService.newService();
        //Future<?> future = service.submit(() -> {
        //    try {
        //        TimeUnit.SECONDS.sleep(10);
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }
        //    System.out.println("I am finish done.");
        //});
        //Object o = future.get();
        //System.out.println(o);

        //有返回值
        //FutureService<String, Integer> service = FutureService.newService();
        //Future<Integer> future = service.submit(input -> {
        //    try {
        //        TimeUnit.SECONDS.sleep(5);
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }
        //    return input.length();
        //}, "Hello");
        //System.out.println(future.get());

        //回调方式返回结果
        FutureService<String, Integer> service = FutureService.newService();
        service.submit(input -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return input.length();
        }, "Hello", System.out::println);
    }


}
