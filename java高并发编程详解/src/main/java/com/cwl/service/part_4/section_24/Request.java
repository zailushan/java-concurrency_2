package com.cwl.service.part_4.section_24;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/3113:28
 */
public class Request {

    private final String business;

    public Request(String business) {
        this.business = business;
    }

    @Override
    public String toString() {
        return business;
    }
}
