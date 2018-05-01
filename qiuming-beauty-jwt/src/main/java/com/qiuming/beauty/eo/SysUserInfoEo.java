/**
 * @(#)${file_name} 1.0  2018:04:18
 * <p>
 * Copyright (c) 2017, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.eo;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * @description: 用户详情表
 * @author: ji.shamo
 * @create: 2018-04-18 21:34
 **/
@Entity
@Table(name = "sys_user_info")
public class SysUserInfoEo{
    /** 账号id */
    @Column(name = "account_id")
    private Long accountId;
    /** 昵称 */
    @Column(name = "nick_name")
    private String nickName;
    /** 真实姓名 */
    @Column(name = "real_name")
    private String realName;
    /** 头像 */
    @Column(name = "avatar_url")
//    @Lob
//    @Type(type="org.hibernate.type.BinaryType")
    private String avatarUrl;
    /** 性别 */
    @Column(name = "gender")
    private Integer gender;
    /** 生日 */
    @Column(name = "birthday")
    private Date birthday;
    /** 省编码 */
    @Column(name = "province_code")
    private String provinceCode;
    /** 市编码 */
    @Column(name = "city_code")
    private String cityCode;
    /** 区编码 */
    @Column(name = "area_code")
    private String areaCode;
    /** 街道编码 */
    @Column(name = "street_code")
    private String streetCode;
    /** 地址 */
    @Column(name = "address")
    private String address;
    /** 纬度*/
    @Column(name = "longitude")
    private String longitude;
    /** 经度 */
    @Column(name = "latitude")
    private String latitude;
    /** 邮编 */
    @Column(name = "postcode")
    private String postcode;
    /** 证件类型 */
    @Column(name = "card_type")
    private Integer cardType;
    /** 证件号码*/
    @Column(name = "card_no")
    private String cardNo;
    /** 账号类型 */
    @Column(name = "type")
    private Integer type;
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

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
