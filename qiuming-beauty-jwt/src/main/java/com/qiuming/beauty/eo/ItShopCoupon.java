/**
 * @(#) ${FILE_NAME} 1.0  2018:04:21
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.eo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @description: 店铺优惠信息表
 * @author: ji.shamo
 * @create: 2018-04-21 23:10
 **/
@Entity
@Table(name = "it_shop_coupon")
public class ItShopCoupon extends BaseEo{
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "shop_id")
    private Long shopId;

    @Column(name = "coupon")
    private BigDecimal coupon;
    @Column(name = "discount")
    private BigDecimal discount;
    @Column(name = "total_price")
    /** 满减额度*/
    private BigDecimal totalPrice;
    @Column(name = "active_time")
    private Date activeTime;
    @Column(name = "failure_time")
    private Date failureTime;
    /** 优惠类型 1 满减 2 折扣 */
    @Column(name = "type")
    private Integer type;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public BigDecimal getCoupon() {
        return coupon;
    }

    public void setCoupon(BigDecimal coupon) {
        this.coupon = coupon;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Date getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Date activeTime) {
        this.activeTime = activeTime;
    }

    public Date getFailureTime() {
        return failureTime;
    }

    public void setFailureTime(Date failureTime) {
        this.failureTime = failureTime;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
