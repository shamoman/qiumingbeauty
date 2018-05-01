/**
 * @(#) ${FILE_NAME} 1.0  2018:05:01
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.dto;

import com.qiuming.beauty.eo.TrOrderEo;

/**
 *
 * @description: 订单列表dto
 * @author: ji.shamo
 * @create: 2018-05-01 12:32
 **/
public class OrderListDto extends TrOrderEo {

    private String itemName;

    private String itemImage;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }
}
