/**
 * @(#) ${FILE_NAME} 1.0  2018:04:20
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.service;

import com.qiuming.beauty.eo.ItShopBarberEo;

import java.util.List;

/**
 *
 * @description: 理发师service接口类
 * @author: ji.shamo
 * @create: 2018-04-20 22:49
 **/
public interface IShopBarberService {
    /**
     * 新增店铺理发师
     * @param eo - 理发师实体
     */
    public void addShopBarber(ItShopBarberEo eo);

    /**
     * 批量新增
     * @param eos - list
     */
    public void addShopBarberList(List<ItShopBarberEo> eos);

    /**
     * 更新店铺理发师
     * @param eo- 理发师实体
     */
    public void updateShopBarber(ItShopBarberEo eo);

    /**
     * 根据主键删除理发师
     * @param barberId - 主键
     */
    public void deleteShopBarber(Long barberId);

    /**
     * 根据店铺id 查询理发师
     * @param shopId - 店铺id
     * @return
     */
    public List<ItShopBarberEo> findShopBarberList(Long shopId);
}
