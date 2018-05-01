/**
 * @(#) ${FILE_NAME} 1.0  2018:05:01
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.dto;

/**
 *
 * @description: 支付dto
 * @author: ji.shamo
 * @create: 2018-05-01 22:28
 **/
public class PayOrderDto extends BaseVo{
    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
