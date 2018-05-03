/**
 * @(#) ${FILE_NAME} 1.0  2018:04:30
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.dto;

import com.qiuming.beauty.eo.TrOrderEo;

/**
 *
 * @description: 订单详情
 * @author: ji.shamo
 * @create: 2018-04-30 17:18
 **/
public class OrderDetailDto extends TrOrderEo {

    private String orderTimeStr;

    private String finishTimeStr;

    private String cancelTimeStr;

    public String getOrderTimeStr() {
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public String getFinishTimeStr() {
        return finishTimeStr;
    }

    public void setFinishTimeStr(String finishTimeStr) {
        this.finishTimeStr = finishTimeStr;
    }

    public String getCancelTimeStr() {
        return cancelTimeStr;
    }

    public void setCancelTimeStr(String cancelTimeStr) {
        this.cancelTimeStr = cancelTimeStr;
    }
}
