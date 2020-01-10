package com.cwl.service.part_1.pool;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/2010:59
 */
public class RunnableDenyException extends RuntimeException {

    public RunnableDenyException(String message) {
        super(message);
    }
}
