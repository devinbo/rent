package com.xxz.rent.dto.enumerate;


/**
 * 租期单位
 * @author xxz
 */

public enum RentUnit {
    /**
     * 租期单位：天
     */
    DAY(0, "天"),
    /**
     * 租期单位：周
     */
    WEEK(1, "周"),
    /**
     * 租期单位：月
     */
    MONTH(2, "月"),
    /**
     * 租期单位：年
     */
    YEAR(3, "年");

    private int value;
    private String name;

    RentUnit(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
