package com.cwl.service.part_4.section_27;

/**
 * @author cwl
 * @description: TODO
 * @date 2020/1/317:04
 */
public final class OrderServiceFactory {

    //将ActiveMessageQueue定义成static的目的是，保持其在整个JVM进程中是唯一的，
    // 并且ActiveDaemonThread会在此刻启动
    private final static ActiveMessageQueue activeMessageQueue = new ActiveMessageQueue();

    //不允许外部通过new的方式创建
    private OrderServiceFactory() {}

    public static OrderService toActiveObject(OrderService orderService) {
        return new OrderServiceProxy(orderService, activeMessageQueue);
    }

}
