package com.xxz.rent.portal.model.enumerate;


/**
 * 活动信息
 * @author xxz
 */
public enum PromotionStatus {

    NO(0, "无优惠活动"), FRISTSUB(1, "首期租金减免活动"), FREECHARGE(2, "免押金");


    private Integer status;
    private String name;

    PromotionStatus(Integer status, String name) {
        this.status = status;
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public static String get(Integer status) {
        if(NO.status.equals(status)) {
            return NO.name;
        }else if(FRISTSUB.status.equals(status)) {
            return FRISTSUB.name;
        }else if(FREECHARGE.status.equals(status)) {
            return FREECHARGE.name;
        }else{
            return NO.name;
        }
    }
}
