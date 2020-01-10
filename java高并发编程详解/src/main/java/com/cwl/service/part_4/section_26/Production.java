package com.cwl.service.part_4.section_26;

/**
 * @author cwl
 * @description: TODO
 * @date 2020/1/39:41
 */
public class Production extends InstructionBook {

    private final int prodID;

    public Production(int prodID) {
        this.prodID = prodID;
    }

    @Override
    protected void firstProcess() {
        System.out.println("execute the " + prodID + " first process");
    }

    @Override
    protected void secondProcess() {
        System.out.println("execute the " + prodID + " second process");
    }
}
