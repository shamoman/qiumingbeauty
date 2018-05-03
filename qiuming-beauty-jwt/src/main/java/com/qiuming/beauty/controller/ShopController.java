/**
 * @(#) ${FILE_NAME} 1.0  2018:04:20
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.controller;

import com.qiuming.beauty.dto.RestResponse;
import com.qiuming.beauty.dto.ShopDetailDto;
import com.qiuming.beauty.dto.ShopListDto;
import com.qiuming.beauty.dto.ShopListRequestDto;
import com.qiuming.beauty.service.IShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @description: 店铺接口
 * @author: ji.shamo
 * @create: 2018-04-20 23:37
 **/
@RestController
@CrossOrigin
@RequestMapping(value = "/qiuming/beauty/shop")
public class ShopController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private IShopService shopService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public RestResponse findShopList(@RequestParam(value = "address", required = false)String address,
                                     @RequestParam(value = "provinceName", required = false)String provinceName,
                                     @RequestParam(value = "cityName", required = false)String cityName,
                                     @RequestParam(value = "areaName", required = false)String areaName,
                                     @RequestParam(value = "streetName", required = false)String streetName,
                                     @RequestParam(value = "shopName", required = false)String shopName){
        logger.info("查询店铺 list  ");
        ShopListRequestDto dto = new ShopListRequestDto();
        dto.setAreaName(areaName);
        dto.setCityName(cityName);
        dto.setProvinceName(provinceName);
        dto.setShopName(shopName);
        dto.setStreetName(streetName);
        dto.setAddress(address);
        List<ShopListDto> shopEos = shopService.findShopListByParams(dto);
        return new RestResponse(shopEos);
    }

    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public RestResponse showDetail(@RequestParam(value = "shopId") Long shopId){
        ShopDetailDto detailDto = shopService.getShopById(shopId);

        return new RestResponse(detailDto);
    }

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public RestResponse show(){
        List<ShopListDto> listDtos = shopService.findShopListOrderByCommonScore();
        return new RestResponse(listDtos);
    }

}
