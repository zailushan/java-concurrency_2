package com.cwl.service.part_4.section_25;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/3116:34
 */
public class Reference {

    //1M
    private final byte[] data = new byte[2 << 19];

    @Override
    protected void finalize() throws Throwable {
        System.out.println("the reference will be GC.");
    }
}
