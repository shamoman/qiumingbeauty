/**
 * @(#) ${FILE_NAME} 1.0  2018:04:20
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.controller;

import com.alibaba.fastjson.JSON;
import com.qiuming.beauty.dto.RestResponse;
import com.qiuming.beauty.dto.ShopAddDto;
import com.qiuming.beauty.dto.ShopListDto;
import com.qiuming.beauty.eo.ItItemEo;
import com.qiuming.beauty.eo.ItShopBarberEo;
import com.qiuming.beauty.service.IItItemService;
import com.qiuming.beauty.service.IShopBarberService;
import com.qiuming.beauty.service.IShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @description: 系统管理后台接口
 * @author: ji.shamo
 * @create: 2018-04-20 22:33
 **/
@RestController
@RequestMapping(value = "/qiuming/beauty/mgmt/system")
public class SystemController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private IShopService shopService;
    @Resource
    private IShopBarberService shopBarberService;
    @Resource
    private IItItemService iItItemService;

    /**
     * 运营后台-新增店铺
     * @param shopEo - 店铺实体
     * @return
     */
    @RequestMapping(value = "/shop/add",method = RequestMethod.POST)
    public RestResponse addShopList(@RequestBody ShopAddDto shopEo){
        logger.info("开始新增店铺 | {}", JSON.toJSONString(shopEo));
        if (null == shopEo){
            return new RestResponse(-1, "参数错误");
        }
        shopService.addShopDto(shopEo);
        return RestResponse.SUCCESS;
    }

    /**
     * 运营后台 - 删除店铺
     * @param shopId - 店铺id
     * @return
     */
    @RequestMapping(value = "/shop/delete",method = RequestMethod.DELETE)
    public RestResponse addShopList(@RequestParam Long shopId){
        logger.info("开始删除店铺 | {}", JSON.toJSONString(shopId));
        shopService.deleteShopById(shopId);
        return RestResponse.SUCCESS;
    }

    /**
     * 运营后台 - 店铺列表
     * @return
     */
    @RequestMapping(value = "/shop/list",method = RequestMethod.GET)
    public RestResponse shopList(){
        List<ShopListDto> shopEos = shopService.findShopList();
        Map result = new HashMap();
        result.put("list", shopEos);
        return new RestResponse(result);
    }

    /**
     * 运营后台-新增理发师
     * @param shopBarberEo - 理发师实体eo
     * @return
     */
    @RequestMapping(value = "/shop/barber/add",method = RequestMethod.POST)
    public RestResponse addShopBarber(@RequestBody ItShopBarberEo shopBarberEo){
        logger.info("开始新增店铺发型师 | {}", JSON.toJSONString(shopBarberEo));
        shopBarberService.addShopBarber(shopBarberEo);
        return RestResponse.SUCCESS;
    }

    /**
     * 运营后台-删除店铺理发师
     * @param shopBarberId - 理发师id
     * @return
     */
    @RequestMapping(value = "/shop/barber/delete",method = RequestMethod.DELETE)
    public RestResponse addShopBarber(@RequestParam Long shopBarberId){
        logger.info("开始删除店铺发型师 | {}", JSON.toJSONString(shopBarberId));
        shopBarberService.deleteShopBarber(shopBarberId);
        return RestResponse.SUCCESS;
    }

    /**
     * 运营后台理-发师列表
     * @param shopId - 店铺id
     * @return
     */
    @RequestMapping(value = "/shop/barber/list",method = RequestMethod.GET)
    public RestResponse shopBarberList(@RequestParam Long shopId){
        List<ItShopBarberEo> list = shopBarberService.findShopBarberList(shopId);
        Map result = new HashMap();
        result.put("list", list);
        return new RestResponse(result);    }

    /**
     * 新增商品
     * @param itemEo - 商品实体
     * @return
     */
    @RequestMapping(value = "/shop/item/add",method = RequestMethod.POST)
    public RestResponse addShopItem(@RequestBody ItItemEo itemEo){
        if (null == itemEo || null == itemEo.getShopId() || StringUtils.isEmpty(itemEo.getName())){
            return new RestResponse(-1, "参数错误");
        }
        iItItemService.addItem(itemEo);
        return RestResponse.SUCCESS;
    }

    /**
     * 删除商品
     * @param itemId- 商品id
     * @return
     */
    @RequestMapping(value = "/shop/item/delete",method = RequestMethod.DELETE)
    public RestResponse deleteItem(@RequestParam Long itemId){
        logger.info("开始删除店铺发型师 | {}", JSON.toJSONString(itemId));
        iItItemService.deleteItem(itemId);
        return RestResponse.SUCCESS;
    }

    /**
     * 商品列表
     * @param shopId - 店铺id
     * @return
     */
    @RequestMapping(value = "/shop/item/list",method = RequestMethod.DELETE)
    public RestResponse findShopList(@RequestParam Long shopId){
        logger.info("查询店铺列表 | {}", JSON.toJSONString(shopId));
        List<ItItemEo> list = iItItemService.findItemList(shopId);
        Map result = new HashMap();
        result.put("list", list);
        return new RestResponse(result);
    }

}
