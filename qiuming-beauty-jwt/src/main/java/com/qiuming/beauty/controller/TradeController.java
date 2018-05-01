/**
 * @(#) ${FILE_NAME} 1.0  2018:04:23
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.controller;

import com.alibaba.fastjson.JSON;
import com.qiuming.beauty.dto.*;
import com.qiuming.beauty.eo.TrOrderEo;
import com.qiuming.beauty.service.ICommentService;
import com.qiuming.beauty.service.ITrOderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @description: 交易服务接口
 * @author: ji.shamo
 * @create: 2018-04-23 23:49
 **/

@RestController
@RequestMapping(value = "/qiuming/beauty/trade")
public class TradeController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ITrOderService trOderService;
    @Resource
    private ICommentService commentService;

    @RequestMapping(value = "/order/submit", method = RequestMethod.POST)
    public RestResponse submitOrder(@RequestBody OrderSubmitDto submitDto) {
        logger.info("提交订单信息 | {}", JSON.toJSONString(submitDto));
        submitDto.setMemberId(1l);
        AppToPayOrderRespDto dto = trOderService.submitOrder(submitDto);
        return new RestResponse(dto);
    }

    @RequestMapping(value = "/order/detail", method = RequestMethod.GET)
    public RestResponse findOrderByKey(@RequestParam(value = "orderId") Long orderId) {
        logger.info("查询订单信息 | {}", orderId);
        OrderDetailDto dto = trOderService.getOrderDetaii(orderId);
        return new RestResponse(dto);
    }

    @RequestMapping(value = "/order/list", method = RequestMethod.GET)
    public RestResponse findMyOrderList() {
        logger.info("查询我的订单列表 | ");
        List<OrderListDto> list = trOderService.getOrderList(1l);
        return new RestResponse(list);
    }
    @RequestMapping(value = "/order/pay", method = RequestMethod.POST)
    public RestResponse payOrder(Long orderId) {
        logger.info("支付订单 | {}", orderId);
        trOderService.payOrder(1l);
        return RestResponse.SUCCESS;

    }

    @RequestMapping(value = "/order/comment/add", method = RequestMethod.POST)
    public RestResponse orderComment(@RequestBody CommentAddDto commentAddDto) {
        logger.info("评论 | {}", JSON.toJSONString(commentAddDto));

        return RestResponse.SUCCESS;

    }

}
