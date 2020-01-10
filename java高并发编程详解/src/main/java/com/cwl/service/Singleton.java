package com.cwl.service;

/**
 * @author cwl
 * @description: TODO
 * @date 2020/1/616:08
 */
public class Singleton {
    static volatile Singleton instance;

    public Object o;

    public Singleton() {
        this.o = new Object();
    }

    static Singleton getInstance(){
        if (instance == null) {
            synchronized(Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
