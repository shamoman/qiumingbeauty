/**
 * @(#) ${FILE_NAME} 1.0  2018:04:23
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.service;

import com.qiuming.beauty.dto.AppToPayOrderRespDto;
import com.qiuming.beauty.dto.OrderDetailDto;
import com.qiuming.beauty.dto.OrderListDto;
import com.qiuming.beauty.dto.OrderSubmitDto;
import com.qiuming.beauty.eo.TrOrderEo;

import java.util.List;

/**
 *
 * @description: 订单接口
 * @author: ji.shamo
 * @create: 2018-04-23 23:52
 **/
public interface ITrOderService {
    /**
     * 提交订单
     * @param dto - 提交订单dto
     */
    public AppToPayOrderRespDto submitOrder(OrderSubmitDto dto);

    /**
     * 获取订单详情
     * @param orderId - 订单id
     * @return
     */
    public OrderDetailDto getOrderDetaii(Long orderId);

    /**
     * 根据用户id查询订单列表
     * @param memberId - 用户id
     * @return
     */
    public List<OrderListDto> getOrderList(Long memberId);

    /**
     * 支付订单
     * @param orderId - 订单id
     */
    public void payOrder(Long orderId);
}
