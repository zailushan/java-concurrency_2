package com.cwl.service.part_2;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/2317:27
 */
public class ExtClassLoader {

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.ext.dirs"));

        System.out.println(ExtClassLoader.class.getClassLoader());
    }

}
