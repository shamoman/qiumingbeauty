package com.qiuming.beauty.constants;

/**
 * 优惠券类型枚举
 */
public enum CouponTypeEnum {
    MONEY_OFF(1, "满减"),
    DISCOUNT(2, "折扣"),
    ;
    private Integer type;
    private String desc;

    CouponTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
