/**
 * @(#) ${FILE_NAME} 1.0  2018:04:23
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.dto;

import java.math.BigDecimal;

/**
 *
 * @description: 订单dto
 * @author: ji.shamo
 * @create: 2018-04-23 23:55
 **/
public class OrderSubmitDto extends BaseVo{
    /** 店铺ID */
    private Long shopId;
    /** 商品ID */
    private Long itemId;
    /** 用户id */
    private Long memberId;
    /**理发师id*/
    private Long barberId;
    /** 电话号码 */
    private String phone;
    /** 用户名 */
    private String memberUsername;
    /** 商品总数 */
    private Integer totalItemNum;
    /** 支付总金额 */
    private BigDecimal payAmount;
    /** 商品总金额 */
    private BigDecimal itemAmoun;
    /** 优惠总金额 */
    private BigDecimal couponAmount;
    /** 满减金额 */
    private BigDecimal moneyFee;
    /** 买家备注 */
    private String remark;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getBarberId() {
        return barberId;
    }

    public void setBarberId(Long barberId) {
        this.barberId = barberId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberUsername() {
        return memberUsername;
    }

    public void setMemberUsername(String memberUsername) {
        this.memberUsername = memberUsername;
    }

    public Integer getTotalItemNum() {
        return totalItemNum;
    }

    public void setTotalItemNum(Integer totalItemNum) {
        this.totalItemNum = totalItemNum;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getItemAmoun() {
        return itemAmoun;
    }

    public void setItemAmoun(BigDecimal itemAmoun) {
        this.itemAmoun = itemAmoun;
    }

    public BigDecimal getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(BigDecimal couponAmount) {
        this.couponAmount = couponAmount;
    }

    public BigDecimal getMoneyFee() {
        return moneyFee;
    }

    public void setMoneyFee(BigDecimal moneyFee) {
        this.moneyFee = moneyFee;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
