package com.cwl.service.part_4.section_27;

import com.cwl.service.part_4.section_19.Future;
import com.cwl.service.part_4.section_19.FutureService;

import java.util.concurrent.TimeUnit;


/**
 * @author cwl
 * @description: TODO
 * @date 2020/1/313:47
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public Future<String> findOrderDetails(long orderId) {
        return FutureService.<Long, String>newService().submit(input -> {
            try {
                //通过休眠来模拟该方法的执行比较耗时
                TimeUnit.SECONDS.sleep(10);
                System.out.println("process the orderID->" + orderId);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "The order Details Information";
        }, orderId, null);
    }

    @Override
    public void order(String account, long orderId) {
        try {
            TimeUnit.SECONDS.sleep(10);
            System.out.println("process the order for account " + account + ",orderId " + orderId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
