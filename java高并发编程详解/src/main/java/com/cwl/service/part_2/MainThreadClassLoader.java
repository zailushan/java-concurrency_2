package com.cwl.service.part_2;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/2515:00
 */
public class MainThreadClassLoader {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
    }

}
