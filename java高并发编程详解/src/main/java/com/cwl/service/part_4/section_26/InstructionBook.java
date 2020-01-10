package com.cwl.service.part_4.section_26;

/**
 * @author cwl
 * @description: TODO
 * @date 2020/1/39:38
 */
public abstract class InstructionBook {

    public final void create() {
        this.firstProcess();
        this.secondProcess();
    }

    protected abstract void firstProcess();
    protected abstract void secondProcess();
}
