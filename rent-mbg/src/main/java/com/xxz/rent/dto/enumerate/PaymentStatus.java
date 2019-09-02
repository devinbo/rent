package com.xxz.rent.dto.enumerate;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-09 10:20
 * @description：租金状态：0->待支付；1->已逾期；2->已支付； 3:尚未开始
 * @modified By：
 * @version: ：1.0
 */
public enum PaymentStatus {

    WAITPAY(0, "待支付"), OVERDUE(1, "已逾期"), PAYED(2, "已支付"), NOCREATE(3, "尚未开始");

    private int status;
    private String name;

    PaymentStatus(int status, String name) {
        this.status = status;
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }
}
