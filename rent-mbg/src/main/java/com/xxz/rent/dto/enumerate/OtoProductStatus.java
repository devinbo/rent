package com.xxz.rent.dto.enumerate;

/**
 * @author ：xhb
 * @date ：Created in 2019-08-06 14:32
 * @description：
 * @modified By：
 * @version: ：1.0
 */
public enum OtoProductStatus {
    /**待审核**/
    AUDIT(0, "待审核"),
    /**发布中**/
    PUBLISH(1, "发布中"),
    /**待签约**/
    AWAITSIGN(2, "待签约"),
    /**签约中**/
    SIGNING(3, "签约中"),
    /**已完成**/
    COMPLETE(4, "已完成"),
    /**已拒绝**/
    REFUSE(5, "已拒绝"),
    /**已取消,下架**/
    CANCEL(6, "已取消");

    private int status;
    private String note;

    OtoProductStatus(int status, String note) {
        this.status = status;
        this.note = note;
    }

    public int getStatus() {
        return status;
    }

    public String getNote() {
        return note;
    }
}
