/**
 * @(#) ${FILE_NAME} 1.0  2018:05:03
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.dto;

/**
 *
 * @description: 重置密码dto
 * @author: ji.shamo
 * @create: 2018-05-03 23:14
 **/
public class ResetPwdDto extends BaseVo {

    private Long accountId;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
