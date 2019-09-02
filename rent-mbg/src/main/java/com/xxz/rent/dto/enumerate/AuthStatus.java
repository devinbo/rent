package com.xxz.rent.dto.enumerate;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-11 14:30
 * @description：认证状态
 * @modified By：
 * @version: ：1.0
 */
public enum AuthStatus {
    NOAUTH(0, "尚未认证"), PASS(1, "通过认证"), NOPASS(2, "未通过"), WAITAUDIT(3, "待审核");

    private int status;
    private String note;

    AuthStatus(int status, String note) {
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
