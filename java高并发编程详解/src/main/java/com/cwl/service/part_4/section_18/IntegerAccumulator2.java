package com.cwl.service.part_4.section_18;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/2820:23
 */
public final class IntegerAccumulator2 {

    private final int init;

    public IntegerAccumulator2(int init) {
        this.init = init;
    }

    public IntegerAccumulator2(IntegerAccumulator2 accumulator, int init) {
        this.init = accumulator.getValue() + init;
     }

    public IntegerAccumulator2 add(int i) {
        return new IntegerAccumulator2(this, i);
    }
    public int getValue() {
        return this.init;
    }

    public static void main(String[] args) {
        IntegerAccumulator2 accumulator = new IntegerAccumulator2(0);
        IntStream.range(0, 3).forEach(i -> new Thread(()-> {
            int inc = 0;
            while (true) {
                int oldValue = accumulator.getValue();
                int result = accumulator.add(inc).getValue();
                System.out.println(oldValue + "+" + inc + "=" + result);
                //System.out.println("原对象的value:" + accumulator.getValue());
                if (inc + oldValue != result) {
                    System.out.println("ERROR:" + oldValue + "+" + inc + "=" + result);
                }
                inc++;
                slowly();
            }
        }).start());
    }

    private static void slowly() {
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
