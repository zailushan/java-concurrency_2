package com.cwl.service.part_4.section_15;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/2614:41
 */
public interface TaskLifecycle<T> {

    // 任务启动时会触发onStart方法
    void onStart(Thread thread);

    //任务正在运行时会触发onRunning方法
    void onRunning(Thread thread);

    //任务运行结束时会触发onFinish方法，其中result是任务执行结束后的结果
    void onFinish(Thread thread, T result);

    //任务执行报错时会触发onError方法
    void onError(Thread thread, Exception e);

    class EmptyLifecycle<T> implements TaskLifecycle<T> {

        @Override
        public void onStart(Thread thread) {
            System.out.println("onStart...");
        }

        @Override
        public void onRunning(Thread thread) {
            System.out.println("onRunning...");
        }

        @Override
        public void onFinish(Thread thread, T result) {
            System.out.println("onFinish...");
            System.out.println("result:" + result);
        }

        @Override
        public void onError(Thread thread, Exception e) {
            System.out.println("onError...");
        }
    }
}