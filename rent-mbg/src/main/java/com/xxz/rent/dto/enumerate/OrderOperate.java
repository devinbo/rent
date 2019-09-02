package com.xxz.rent.dto.enumerate;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-08 13:38
 * @description：订单操作描述
 * 操作类型：0->修改；1->审核；2->结算；3->取消； 4->删除；5->签约完成；6->产品买断； 7->产品归还；
 * @modified By：
 * @version: ：1.0
 */
public enum  OrderOperate {
    UPDATE(0, "修改订单"), AUDIT(1, "审核订单"), BALANCE(2, "结算订单"),
    CANCEL(3, "取消订单"), DELETE(4, "删除订单"), SIGN(5, "签约完成，开始计费"),
    BUY(6, "产品买断"), BACK(7, "产品归还"),
    PAY(8, "支付订单");

    private int operateType;
    private String operateContent;

    OrderOperate(int operateType, String operateContent) {
        this.operateType = operateType;
        this.operateContent = operateContent;
    }

    public int getOperateType() {
        return operateType;
    }

    public String getOperateContent() {
        return operateContent;
    }
}
