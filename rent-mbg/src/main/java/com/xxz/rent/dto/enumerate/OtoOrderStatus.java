package com.xxz.rent.dto.enumerate;


/**
 * @author xxz
 */
public enum OtoOrderStatus {

    PAY(0, "待付押金"),
    WAITAUDIT(1, "待审核"),
    SIGNING(2, "签约中"),
    RETURN(3, "已归还"),
    BUY(4, "已买断"),
    CANCEL(5, "已取消"),
    REFUSED(6, "已拒绝"),
    TOBUY(7, "待买断"),
    SIGN(8, "待签约"),
    PAYCOMPLETE(9, "已结清");

    private int status;
    private String name;

    OtoOrderStatus(int status, String name) {
        this.status = status;
        this.name = name;
    }

    public int getStatus() {
        return this.status;
    }

    public String getName() {
        return this.name;
    }

}
