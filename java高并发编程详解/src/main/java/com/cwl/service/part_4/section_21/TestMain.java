package com.cwl.service.part_4.section_21;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/3013:41
 */
public class TestMain {

    public static void main(String[] args) {
        ThreadLocal<Object> threadLocal = new ThreadLocal<Object>(){
            @Override
            protected Object initialValue() {
                return new Object();
            }
        };

        new Thread(() -> {
            System.out.println(threadLocal.get());
        }).start();
        System.out.println(threadLocal.get());
    }



}
