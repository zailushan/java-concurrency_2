package com.cwl.service.part_4.section_27;

import java.util.Map;

/**
 * @author cwl
 * @description: TODO
 * @date 2020/1/316:39
 */
public class OrderMessage extends MethodMessage {

    public OrderMessage(Map<String, Object> params, OrderService orderService) {
        super(params, orderService);
    }

    @Override
    public void execute() {
        //获取参数
        String account = (String) params.get("account");
        long orderId = (long) params.get("orderId");
        //执行真正的order方法
        orderService.order(account, orderId);
    }
}
