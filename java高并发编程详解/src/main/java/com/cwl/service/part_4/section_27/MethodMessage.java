package com.cwl.service.part_4.section_27;

import java.util.Map;

/**
 * @author cwl
 * @description: TODO
 * @date 2020/1/316:27
 */
public abstract class MethodMessage {

    //用于收集方法参数，如果有返回Future类型则一并收集
    protected final Map<String, Object> params;

    protected final OrderService orderService;

    public MethodMessage(Map<String, Object> params, OrderService orderService) {
        this.params = params;
        this.orderService = orderService;
    }

    //抽象方法，扮演work thread的说明书
    public abstract void execute();
}
