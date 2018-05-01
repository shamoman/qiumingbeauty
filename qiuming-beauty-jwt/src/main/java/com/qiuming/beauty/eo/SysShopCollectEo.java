/**
 * @(#) ${FILE_NAME} 1.0  2018:04:21
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.eo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @description: 用户收藏表
 * @author: ji.shamo
 * @create: 2018-04-21 23:15
 **/
public class SysShopCollectEo extends BaseEo {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "account_id")
    private Long accountId;
    @Column(name = "shop_id")
    private Long shopId;
    @Column(name = "collect_time")
    private Long collectTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Long collectTime) {
        this.collectTime = collectTime;
    }
}
