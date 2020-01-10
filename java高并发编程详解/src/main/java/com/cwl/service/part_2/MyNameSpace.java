package com.cwl.service.part_2;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/2513:00
 */
public class MyNameSpace {

    public static void main(String[] args) throws ClassNotFoundException {
        //ClassLoader classLoader = MyNameSpace.class.getClassLoader();
        //Class<?> aClass = classLoader.loadClass("com.cwl.service.part_2.MyNameSpace");
        //Class<?> bClass = classLoader.loadClass("com.cwl.service.part_2.MyNameSpace");
        //System.out.println(aClass.hashCode());
        //System.out.println(bClass.hashCode());
        //System.out.println(aClass == bClass);

        MyClassLoader classLoader1 = new MyClassLoader("D:\\classloader1", null);
        MyClassLoader classLoader2 = new MyClassLoader("D:\\classloader1", null);

        Class<?> aClass = classLoader1.loadClass("com.cwl.service.part_2.HelloWorld");
        Class<?> bClass = classLoader2.loadClass("com.cwl.service.part_2.HelloWorld");
        System.out.println(bClass.getClassLoader());
        System.out.println(aClass.hashCode());
        System.out.println(bClass.hashCode());
        System.out.println(aClass == bClass);
    }
}
