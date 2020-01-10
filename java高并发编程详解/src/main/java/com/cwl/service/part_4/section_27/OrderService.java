package com.cwl.service.part_4.section_27;

import com.cwl.service.part_4.section_19.Future;

/**
 * @author cwl
 * @description: TODO
 * @date 2020/1/313:43
 */
public interface OrderService {

    //根据订单编号查询订单明细，有入参也有返回值，但是返回值类型必须是Future
    Future<String> findOrderDetails(long orderId);

    //提交订单，没有返回值
    void order(String account, long orderId);
}
