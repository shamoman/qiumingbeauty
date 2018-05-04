/**
 * @(#)${file_name} 1.0  2018:04:19
 * <p>
 * Copyright (c) 2017, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.eo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @description: 订单表
 * @author: ji.shamo
 * @create: 2018-04-19 23:49
 **/
@Entity
@Table(name = "tr_order")
public class TrOrderEo extends BaseEo {
    @Id
    @GeneratedValue
    private Long id;
    /** 订单号 */
    @Column(name = "order_no")
    private String orderNo;
    /** 店铺ID */
    @Column(name = "shop_id")
    private Long shopId;
    /** 店铺名 */
    @Column(name = "shop_name")
    private String shopName;

    @Column(name = "item_name")
    private String itemName;
    /** 商品ID */
    @Column(name = "item_id")
    private Long itemId;
    /** 用户id */
    @Column(name = "member_id")
    private Long memberId;
    /** 用户id */
    @Column(name = "barber_id")
    private Long barberId;
    /** 用户名 */
    @Column(name = "member_username")
    private String memberUsername;
    /** 电话 */
    @Column(name = "phone")
    private String phone;
    /** 状态 */
    @Column(name = "status")
    private Integer status;
    /** 商品总数 */
    @Column(name = "total_item_num")
    private Integer totalItemNum;
    /** 支付总金额 */
    @Column(name = "pay_amount")
    private BigDecimal payAmount;
    /** 商品总金额 */
    @Column(name = "item_amount")
    private String itemAmoun;
    /** 优惠总金额 */
    @Column(name = "coupon_amount")
    private BigDecimal couponAmount;
    /** 满减金额 */
    @Column(name = "money_fee")
    private BigDecimal moneyFee;
    /** 买家备注 */
    @Column(name = "remark")
    private String remark;
    /** 下单时间 */
    @Column(name = "order_time")
    private Date orderTime;
    /** 支付时间 */
    @Column(name = "pay_time")
    private Date payTime;
    /** 完成时间 */
    @Column(name = "finish_time")
    private Date finishTime;
    /** 取消时间 */
    @Column(name = "cancel_time")
    private Date cancelTime;
    /** 终止时间 */
    @Column(name = "abort_time")
    private Date abortTime;
    /** 取消类型 */
    @Column(name = "recancel_type")
    private String cancelType;
    /** 取消说明 */
    @Column(name = "cancel_desc")
    private String cancelDesc;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Long getBarberId() {
        return barberId;
    }

    public void setBarberId(Long barberId) {
        this.barberId = barberId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getItemAmoun() {
        return itemAmoun;
    }

    public void setItemAmoun(String itemAmoun) {
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

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public Date getAbortTime() {
        return abortTime;
    }

    public void setAbortTime(Date abortTime) {
        this.abortTime = abortTime;
    }

    public String getCancelType() {
        return cancelType;
    }

    public void setCancelType(String cancelType) {
        this.cancelType = cancelType;
    }

    public String getCancelDesc() {
        return cancelDesc;
    }

    public void setCancelDesc(String cancelDesc) {
        this.cancelDesc = cancelDesc;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
