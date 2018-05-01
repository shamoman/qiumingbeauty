/**
 * @(#) ${FILE_NAME} 1.0  2018:04:23
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.service;

import com.qiuming.beauty.eo.ItItemEo;

import java.util.List;

/**
 *
 * @description: 商品接口
 * @author: ji.shamo
 * @create: 2018-04-23 21:04
 **/
public interface IItItemService {
    /**
     * 新增商品
     * @param eo - 商品eo
     */
    void addItem(ItItemEo eo);

    /**
     * 批量新增
     * @param eos -list
     */
    void addItemList(List<ItItemEo> eos);

    /**
     * 根据店铺id查询店铺列表
     * @param shopId - 店铺id
     * @return
     */
    List<ItItemEo> findItemList(Long shopId);

    /**
     * 删除商品
     * @param itemId - 商品id
     */
    void deleteItem(Long itemId);


}
