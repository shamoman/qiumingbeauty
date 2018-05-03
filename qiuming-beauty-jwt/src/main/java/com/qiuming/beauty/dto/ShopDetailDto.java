/**
 * @(#) ${FILE_NAME} 1.0  2018:04:29
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.dto;

import com.qiuming.beauty.eo.ItItemEo;
import com.qiuming.beauty.eo.ItShopBarberEo;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @description: 店铺详情
 * @author: ji.shamo
 * @create: 2018-04-29 19:55
 **/
public class ShopDetailDto {
    private Long id;
    private String shopName;

    private String phone;

    private Long brandId;

    private String brandName;

    private String introduction;
    /** 省 */
    private String provinceName;
    /** 市 */
    private String cityName;
    /** 区 */
    private String areaName;
    /** 街道 */
    private String streetName;
    /** 地址 */
    private String address;
    /** 纬度*/
    private String longitude;
    /** 经度 */
    private String latitude;
    /** 满减额*/
    private BigDecimal moneyOff;
    /***折扣*/
    private BigDecimal discount;
    /** 优惠金额*/
    private BigDecimal coupon;
    /**
     * 店铺评分
     */
    private BigDecimal commentScore;

    private Long watchCount;
    /** 销量 */
    private Long saleCount;

    /** 评论总数 */
    private Long commentCount;

    List<byte[]> environmentImageList;

    private byte[] shopImage;
    List<ItItemEo> itemList;
    List<ItShopBarberEo> shopBarberList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public List<byte[]> getEnvironmentImageList() {
        return environmentImageList;
    }

    public void setEnvironmentImageList(List<byte[]> environmentImageList) {
        this.environmentImageList = environmentImageList;
    }

    public byte[] getShopImage() {
        return shopImage;
    }

    public void setShopImage(byte[] shopImage) {
        this.shopImage = shopImage;
    }

    public List<ItItemEo> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItItemEo> itemList) {
        this.itemList = itemList;
    }

    public List<ItShopBarberEo> getShopBarberList() {
        return shopBarberList;
    }

    public void setShopBarberList(List<ItShopBarberEo> shopBarberList) {
        this.shopBarberList = shopBarberList;
    }

    public BigDecimal getMoneyOff() {
        return moneyOff;
    }

    public void setMoneyOff(BigDecimal moneyOff) {
        this.moneyOff = moneyOff;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getCoupon() {
        return coupon;
    }

    public void setCoupon(BigDecimal coupon) {
        this.coupon = coupon;
    }

    public BigDecimal getCommentScore() {
        return commentScore;
    }

    public void setCommentScore(BigDecimal commentScore) {
        this.commentScore = commentScore;
    }

    public Long getWatchCount() {
        return watchCount;
    }

    public void setWatchCount(Long watchCount) {
        this.watchCount = watchCount;
    }

    public Long getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Long saleCount) {
        this.saleCount = saleCount;
    }

    public Long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }
}
