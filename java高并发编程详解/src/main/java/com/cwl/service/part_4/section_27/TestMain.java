package com.cwl.service.part_4.section_27;

/**
 * @author cwl
 * @description: TODO
 * @date 2020/1/317:07
 */
public class TestMain {

    public static void main(String[] args) throws InterruptedException {
        //在创建OrderService时需要传递OrderService接口的具体实现
        OrderService orderService = OrderServiceFactory.toActiveObject(new OrderServiceImpl());
        orderService.order("hello", 453453);
        //立即返回
        System.out.println("Return immediately");
        Thread.currentThread().join();
    }

}
