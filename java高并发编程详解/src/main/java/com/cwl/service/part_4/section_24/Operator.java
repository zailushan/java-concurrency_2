package com.cwl.service.part_4.section_24;

import com.cwl.service.part_1.pool.BasicThreadPool;
import com.cwl.service.part_1.pool.ThreadPool;

import java.util.concurrent.*;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/3113:35
 */
public class Operator {

    private final ThreadPool threadPool = new BasicThreadPool(2, 6, 4, 1000);

    //复习一下juc中的线程池的创建
    private final ExecutorService service = Executors.newFixedThreadPool(10);
            //new ThreadPoolExecutor(5, 10,
            //2000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10));


    public void call(String business) {
        TaskHandler taskHandler = new TaskHandler(new Request(business));
        //new Thread(taskHandler).start();
        threadPool.execute(taskHandler);
    }

}
