package com.cwl.service.part_4.section_27;

import com.cwl.service.part_4.section_19.FutureTask;

/**
 * @author cwl
 * @description: TODO
 * @date 2020/1/316:23
 */
public class ActiveFuture<T> extends FutureTask<T> {

    @Override
    protected void finish(T result) {
        super.finish(result);
    }
}
