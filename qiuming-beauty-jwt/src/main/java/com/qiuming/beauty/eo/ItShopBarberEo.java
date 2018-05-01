/**
 * @(#)${file_name} 1.0  2018:04:20
 * <p>
 * Copyright (c) 2017, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.eo;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 *
 * @description: 店铺理发师
 * @author: ji.shamo
 * @create: 2018-04-20 20:47
 **/
@Entity
@Table(name = "it_shop_barber")
public class ItShopBarberEo extends BaseEo{

    @Column(name = "shop_id")
    private Long shopId;

    @Column(name = "name")
    private String name;

    @Column(name = "grade")
    private String grade;

    @Column(name = "times")
    private String times;

    @Column(name = "appoint_tips")
    private BigDecimal appointTips;

    @Column(name = "work_time")
    private String workTime;

    @Column(name = "motto")
    private String motto;

    @Column(name = "status")
    private Integer status;

    @Column(name = "order_count")
    private Integer orderCount;

    @Column(name = "today_count")
    private Integer todayCount;

    @Column(name = "remark")
    private String remark;

    @Column(name = "barber_image")
    private String barberImage;

    @Id
    @GeneratedValue
    private Long id;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public BigDecimal getAppointTips() {
        return appointTips;
    }

    public void setAppointTips(BigDecimal appointTips) {
        this.appointTips = appointTips;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBarberImage() {
        return barberImage;
    }

    public void setBarberImage(String barberImage) {
        this.barberImage = barberImage;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getTodayCount() {
        return todayCount;
    }

    public void setTodayCount(Integer todayCount) {
        this.todayCount = todayCount;
    }
}
