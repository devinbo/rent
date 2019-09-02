package com.xxz.rent.dto.enumerate;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-08 11:38
 * @description：订单状态：0->待付押金；1->待审核；2->签约中；
 * 3->已归还；4->已买断；5->已取消；6->已拒绝；7->待买断；8->待签约/会员收到货
 * @modified By：
 * @version: ：1.0
 *
 */
public enum OrderStatus {
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

    OrderStatus(int status, String name) {
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
