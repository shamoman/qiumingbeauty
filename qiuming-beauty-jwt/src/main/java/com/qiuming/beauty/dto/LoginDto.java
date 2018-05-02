/**
 * @(#) ${FILE_NAME} 1.0  2018:05:02
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.dto;

/**
 *
 * @description: 登陆实体类
 * @author: ji.shamo
 * @create: 2018-05-02 21:06
 **/
public class LoginDto extends BaseVo {

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
