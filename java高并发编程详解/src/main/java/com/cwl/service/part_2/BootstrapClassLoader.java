package com.cwl.service.part_2;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/2317:18
 */
public class BootstrapClassLoader {

    public static void main(String[] args) {
        System.out.println("Bootstrap:" + String.class.getClassLoader());
        System.out.println(System.getProperty("sun.boot.class.path"));
    }


}
