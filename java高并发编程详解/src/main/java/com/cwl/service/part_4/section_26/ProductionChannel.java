package com.cwl.service.part_4.section_26;


/**
 * @author cwl
 * @description: TODO
 * @date 2020/1/39:45
 */
public class ProductionChannel {

    private final static int MAX_PROD = 100;

    private final Production[] productionQueue;

    private int tail;

    private int head;

    private int total;

    private final Worker[] workers;

    public ProductionChannel(int workerSize) {
        this.workers = new Worker[workerSize];
        this.productionQueue = new Production[MAX_PROD];
        for (int i = 0; i < workerSize; i++) {
            workers[i] = new Worker("Worker-" + i, this);
            workers[i].start();
        }
    }

    public void offerProduction(Production production) {
        synchronized (this) {
            while (total >= productionQueue.length) {
                try {
                    this.wait();
                } catch (InterruptedException e) {

                }
            }
            productionQueue[tail] = production;
            tail = (tail + 1) % productionQueue.length;
            total++;
            this.notifyAll();
        }
    }

    public Production taskProduction() {
        synchronized (this) {
            while (total <= 0) {
                try {
                    this.wait();
                } catch (InterruptedException e) {

                }
            }
            Production prod = productionQueue[head];
            head = (head + 1) % productionQueue.length;
            total--;
            this.notifyAll();
            return prod;
        }
    }
}
