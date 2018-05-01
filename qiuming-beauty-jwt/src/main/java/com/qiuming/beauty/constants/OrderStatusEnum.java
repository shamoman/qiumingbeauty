package com.qiuming.beauty.constants;

/**
 * 订单状态枚举
 */
public enum OrderStatusEnum {
    /**
     * 交易订单 订单状态：1.待付款（默认），2.已付款， 3.完成， 4.取消，5.终止
     */
    ORDER_STATUS_PRE(0, "预处理"),
    ORDER_STATUS_DEFAULT(1, "待付款"),
    ORDER_STATUS_PAY(2, "已支付"),
    ORDER_STATUS_FINISH(3, "完成"),
    ORDER_STATUS_CANCEL(4, "取消"),
    ORDER_STATUS_END(5, "终止"),
    ;
    private Integer status;
    private String desc;

    OrderStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
