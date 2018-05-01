/**
 * @(#) ${FILE_NAME} 1.0  2018:04:21
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.dto;

import com.qiuming.beauty.domain.SysUser;
import com.qiuming.beauty.eo.SysUserInfoEo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 *
 * @description: 用户信息dto
 * @author: ji.shamo
 * @create: 2018-04-21 23:30
 **/

@ApiModel(value = "UserDto", description = "用户详情")
public class UserDto {
    @ApiModelProperty(name = "accountId", value = "会员账号ID")
    public Long accountId;

    @ApiModelProperty(name = "username", value = "用户名")
    public String username;

    @ApiModelProperty(name = "realName", value = "昵称")
    public String realName;

    @ApiModelProperty(name = "mobile", value = "电话")
    public String mobile;

    @ApiModelProperty(name = "createTime", value = "注册时间")
    public Date createTime;

    @ApiModelProperty(name = "avatarUrl", value = "头像")
    public String avatarUrl;

    public UserDto(SysUser user, SysUserInfoEo infoEo) {
        this.accountId = user.getId();
        this.username = user.getUsername();
        this.mobile = user.getMobile();
        this.createTime = user.getCreateTime();
        this.avatarUrl = infoEo.getAvatarUrl();
        this.realName = infoEo.getRealName();
    }

    public UserDto() {
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
