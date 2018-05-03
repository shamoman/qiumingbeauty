/**
 * @(#) ${FILE_NAME} 1.0  2018:04:22
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.service.impl;

import com.qiuming.beauty.eo.ItShopBarberEo;
import com.qiuming.beauty.repository.ShopBarberRepository;
import com.qiuming.beauty.service.IShopBarberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @description: 理发师sevice层
 * @author: ji.shamo
 * @create: 2018-04-22 13:43
 **/
@Service("shopBarberService")
public class ShopBarberServiceImpl implements IShopBarberService {

    @Resource
    private ShopBarberRepository shopBarberRepository;
    @Override
    public void addShopBarber(ItShopBarberEo eo) {
        eo.setOrderCount(0);
        shopBarberRepository.save(eo);
    }

    @Override
    public void addShopBarberList(List<ItShopBarberEo> eos) {
        shopBarberRepository.save(eos);
    }

    @Override
    public void updateShopBarber(ItShopBarberEo eo) {

    }

    @Override
    public void deleteShopBarber(Long barberId) {

    }

    @Override
    public List<ItShopBarberEo> findShopBarberList(Long shopId) {
        return shopBarberRepository.findAllByShopId(shopId);
    }
}
