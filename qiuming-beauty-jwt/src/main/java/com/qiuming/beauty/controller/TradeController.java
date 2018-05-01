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
    public RestResponse findMyOrderList(Integer status) {
        logger.info("查询我的订单列表 | status {}", status);
        List<OrderListDto> list = trOderService.getOrderList(status, 1l);
        return new RestResponse(list);
    }
    @RequestMapping(value = "/order/pay", method = RequestMethod.POST)
    public RestResponse payOrder(@RequestBody PayOrderDto orderDto) {
        logger.info("支付订单 | {}", JSON.toJSONString(orderDto));
        if (null == orderDto || null == orderDto.getOrderId()){
            return new RestResponse(-1, "参数异常");
        }
        trOderService.payOrder(orderDto.getOrderId());
        return RestResponse.SUCCESS;
    }
    @RequestMapping(value = "/order/cancel", method = RequestMethod.POST)
    public RestResponse cancelOrder(@RequestBody PayOrderDto orderDto) {
        logger.info("取消订单 | {}", JSON.toJSONString(orderDto));
        if (null == orderDto || null == orderDto.getOrderId()){
            return new RestResponse(-1, "参数异常");
        }
        trOderService.cancelOrder(orderDto.getOrderId());
        return RestResponse.SUCCESS;
    }

    @RequestMapping(value = "/order/finish", method = RequestMethod.POST)
    public RestResponse finishOrder(@RequestBody PayOrderDto orderDto) {
        logger.info("取消订单 | {}", JSON.toJSONString(orderDto));
        if (null == orderDto || null == orderDto.getOrderId()){
            return new RestResponse(-1, "参数异常");
        }
        trOderService.cancelOrder(orderDto.getOrderId());
        return RestResponse.SUCCESS;
    }

    @RequestMapping(value = "/order/comment/add", method = RequestMethod.POST)
    public RestResponse orderComment(@RequestBody CommentAddDto commentAddDto) {
        logger.info("新增评论 | {}", JSON.toJSONString(commentAddDto));
        if (null == commentAddDto || null == commentAddDto.getShopId() || null == commentAddDto.getOrderId())
            commentAddDto.setAccountId(1l);
        commentService.addComment(commentAddDto);
        return RestResponse.SUCCESS;
    }

    @RequestMapping(value = "/order/comment/list", method = RequestMethod.GET)
    public RestResponse orderComment(@RequestParam(value = "shopId") Long shopId) {
        logger.info("查询评论列表 | {}", shopId);
        List<CommentAddDto> list = commentService.findCommentList(shopId);
        return new RestResponse(list);
    }

}
