/**
 * @(#)${file_name} 1.0  2018:04:19
 * <p>
 * Copyright (c) 2017, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.eo;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @description: 店铺表
 * @author: ji.shamo
 * @create: 2018-04-19 00:39
 **/
@Entity
@Table(name = "it_shop")
public class ItShopEo{
    /** 店铺名 */
    @Column(name = "shop_name")
    private String shopName;

    /** 品牌id */
    @Column(name = "brand_name")
    private String brandName;

    /** 简介 */
    @Column(name = "introduction")
    private String introduction;

    /**  状态 */
    @Column(name = "status")
    private Integer status;

    /** 满减额*/
    @Column(name = "money_off")
    private BigDecimal moneyOff;
    /***折扣*/
    @Column(name = "discount")
    private BigDecimal discount;
    /** 满减值*/
    @Column(name = "coupon")
    private BigDecimal coupon;

    /** 销量 */
    @Column(name = "sales_count")
    private Long saleCount;

    /** 评论总数 */
    @Column(name = "comment_count")
    private Long commentCount;

    /** 评分 */
    @Column(name = "comment_score")
    private BigDecimal commentScore;

    /** 收藏总数 */
    @Column(name = "collection_count")
    private Long collectionCount;

    /** 省编码 */
    @Column(name = "province_code")
    private String provinceCode;
    /** 市编码 */
    @Column(name = "city_code")
    private String cityCode;
    /** 区编码 */
    @Column(name = "area_code")
    private String areaCode;
    /** 街道 */
    @Column(name = "street_code")
    private String streetCode;
    /** 省 */
    @Column(name = "province_name")
    private String provinceName;
    /** 市 */
    @Column(name = "city_name")
    private String cityName;
    /** 区*/
    @Column(name = "area_name")
    private String areaName;
    /** 街道 */
    @Column(name = "street_name")
    private String streetName;
    /** 地址 */
    @Column(name = "address")
    private String address;
    /** 纬度*/
    @Column(name = "longitude")
    private String longitude;
    /** 经度 */
    @Column(name = "latitude")
    private String latitude;
    /** 经度 */
    @Column(name = "shop_image", length = 100000)
    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] shopImage;
    /** 图片 */
    @Column(name = "url1", length = 100000)
    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] url1;
    /** 图片2 */
    @Column(name = "url2", length = 100000)
    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] url2;
    /** 图片3 */
    @Column(name = "url3", length = 100000)
    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] url3;
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "create_person")
    private String createPerson;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_person")
    private String updatePerson;
    @Column(name = "update_time")
    private Date updateTime;
    @Column
    private int dr;

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(String updatePerson) {
        this.updatePerson = updatePerson;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getDr() {
        return dr;
    }

    public void setDr(int dr) {
        this.dr = dr;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Long getCollectionCount() {
        return collectionCount;
    }

    public void setCollectionCount(Long collectionCount) {
        this.collectionCount = collectionCount;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getStreetCode() {
        return streetCode;
    }

    public void setStreetCode(String streetCode) {
        this.streetCode = streetCode;
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

    public byte[] getUrl1() {
        return url1;
    }

    public void setUrl1(byte[] url1) {
        this.url1 = url1;
    }

    public byte[] getUrl2() {
        return url2;
    }

    public void setUrl2(byte[] url2) {
        this.url2 = url2;
    }

    public byte[] getUrl3() {
        return url3;
    }

    public void setUrl3(byte[] url3) {
        this.url3 = url3;
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

    public byte[] getShopImage() {
        return shopImage;
    }

    public void setShopImage(byte[] shopImage) {
        this.shopImage = shopImage;
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
}
