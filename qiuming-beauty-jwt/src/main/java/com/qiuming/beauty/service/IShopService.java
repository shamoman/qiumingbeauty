/**
 * @(#) ${FILE_NAME} 1.0  2018:04:20
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.service;

import com.qiuming.beauty.dto.ShopAddDto;
import com.qiuming.beauty.dto.ShopDetailDto;
import com.qiuming.beauty.dto.ShopListDto;
import com.qiuming.beauty.dto.ShopListRequestDto;
import com.qiuming.beauty.eo.ItShopEo;

import java.util.List;

/**
 *
 * @description: 店铺service层
 * @author: ji.shamo
 * @create: 2018-04-20 22:40
 **/
public interface IShopService {
    /**
     * 新增店铺
     * @param shopEo - 店铺实体
     */
    public void addShop(ItShopEo shopEo);
    /**
     * 新增店铺
     * @param shopEo - 店铺封装实体
     */
    public void addShopDto(ShopAddDto shopEo);

    /**
     * 更新店铺
     * @param shopEo - 店铺实体
     */
    public void updateShop(ItShopEo shopEo);

    /**
     *  根据主键删除店铺
     * @param shopId - 店铺id
     */
    public void deleteShopById(Long shopId);

    /**
     * 根据店铺id获取店铺详情
     * @param shopId
     * @return
     */
    public ShopDetailDto getShopById(Long shopId);

    /**
     * 查询店铺列表
     * @return
     */
    public List<ShopListDto> findShopList();

    /**
     * 根据参数批量查询
     * @param dto
     * @return
     */
    public List<ShopListDto> findShopListByParams(ShopListRequestDto dto);

    /**
     * 根据店铺评分倒叙
     * @return
     */
    public List<ShopListDto> findShopListOrderByCommonScore();
}
