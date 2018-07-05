/**
 * @(#) ${FILE_NAME} 1.0  2018:07:04
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @description: authDto
 * @author: ji.shamo
 * @create: 2018-07-04 20:56
 **/
public class ThirdOauthDto {
    @JSONField(
            name = "access_token"
    )
    private String accessToken;
    @JSONField(
            name = "expires_in"
    )
    private Integer expiresIn;
    @JSONField(
            name = "refresh_token"
    )
    private String refreshToken;
    private String uid;
    private String openid;
    private String scope;
    private String unionid;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
}
