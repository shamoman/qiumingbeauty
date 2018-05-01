/**
 * @(#) ${FILE_NAME} 1.0  2018:04:23
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.service.impl;

import com.qiuming.beauty.eo.ItItemEo;
import com.qiuming.beauty.repository.ItItemRepository;
import com.qiuming.beauty.service.IItItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @description: 商品service层
 * @author: ji.shamo
 * @create: 2018-04-23 21:05
 **/
@Service("itItemService")
public class ItItemServiceImpl implements IItItemService {
    @Resource
    private ItItemRepository itItemRepository;

    @Override
    public void addItem(ItItemEo eo) {
        itItemRepository.save(eo);
    }

    @Override
    public void addItemList(List<ItItemEo> eos) {
        itItemRepository.save(eos);
    }

    @Override
    public List<ItItemEo> findItemList(Long shopId) {
        return itItemRepository.findByShopId(shopId);
    }

    @Override
    public void deleteItem(Long itemId) {
        itItemRepository.delete(itemId);
    }
}
