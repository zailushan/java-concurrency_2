package com.cwl.service.part_2;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/2319:04
 */
public class ApplicationClassLoader {

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(ApplicationClassLoader.class.getClassLoader());
    }

}
