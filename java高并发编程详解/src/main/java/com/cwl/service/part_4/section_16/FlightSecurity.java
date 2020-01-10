package com.cwl.service.part_4.section_16;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/2616:17
 */
public class FlightSecurity {

    private int count = 0;

    private String boardingPass = "null";

    private String idCard = "null";

    public void pass(String boardingPass, String idCard) {
        this.boardingPass = boardingPass;
        this.idCard = idCard;
        this.count++;
        this.check();
    }

    private void check() {
        if (boardingPass.charAt(0) != idCard.charAt(0)) {
            throw new RuntimeException("=====Exception=====" + toString());
        }
    }

    @Override
    public String toString() {
        return "The " + count + " passengers,boardingPass [" + boardingPass + "], idCard [" + idCard + "]";
    }
}
