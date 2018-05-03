/**
 * @(#) ${FILE_NAME} 1.0  2018:05:03
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.dto;

/**
 *
 * @description: 更新密码dto
 * @author: ji.shamo
 * @create: 2018-05-03 19:35
 **/
public class PasswordDto extends BaseVo {

    private String oldPassword;

    private String password;

    private String confirmPwd;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPwd() {
        return confirmPwd;
    }

    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
    }
}
