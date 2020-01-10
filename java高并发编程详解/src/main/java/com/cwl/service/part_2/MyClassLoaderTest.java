package com.cwl.service.part_2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/2410:08
 */
public class MyClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //1.
        //MyClassLoader classLoader = new MyClassLoader();
        //2.
        //ClassLoader extClassLoader = MyClassLoaderTest.class.getClassLoader().getParent();
        //MyClassLoader classLoader = new MyClassLoader("D:\\classloader1", extClassLoader);
        //3.
        MyClassLoader classLoader = new MyClassLoader("D:\\classloader1", null);

        Class<?> aClass = classLoader.loadClass("com.cwl.service.part_2.HelloWorld");
        System.out.println(aClass.getClassLoader());
        Object helloWorld = aClass.newInstance();
        System.out.println(helloWorld);
        Method welcome = aClass.getMethod("welcome");
        String result = (String) welcome.invoke(helloWorld);
        System.out.println("Result:" + result);
    }
}
