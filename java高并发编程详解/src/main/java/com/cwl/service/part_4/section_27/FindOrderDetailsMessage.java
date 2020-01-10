package com.cwl.service.part_4.section_27;

import com.cwl.service.part_4.section_19.Future;

import java.util.Map;

/**
 * @author cwl
 * @description: TODO
 * @date 2020/1/316:30
 */
public class FindOrderDetailsMessage extends MethodMessage {

    public FindOrderDetailsMessage(Map<String, Object> params, OrderService orderService) {
        super(params, orderService);
    }

    @Override
    public void execute() {
        Future<String> realFuture = orderService.findOrderDetails((Long) params.get("orderId"));
        ActiveFuture<String> activeFuture = (ActiveFuture<String>) params.get("activeFuture");
        try {
            String result = realFuture.get();
            activeFuture.finish(result);
        } catch (InterruptedException e) {
            activeFuture.finish(null);
        }

    }
}
