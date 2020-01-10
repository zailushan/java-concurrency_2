package com.cwl.service.part_1;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/1616:20
 */
public abstract class TemplateMethod {

    public final void print(String message) {
        System.out.println("###########");
        wrapPrint(message);
        System.out.println("###########");
    }

    public abstract void wrapPrint(String message);

    public static void main(String[] args) {
        TemplateMethod t1 = new TemplateMethod() {
            @Override
            public void wrapPrint(String message) {
                System.out.println("*" + message + "*");
            }
        };
        t1.print("hello Thread");

        TemplateMethod t2 = new TemplateMethod() {
            @Override
            public void wrapPrint(String message) {
                System.out.println("+" + message + "+");
            }
        };
        t2.print("hello Thread");
    }
}
