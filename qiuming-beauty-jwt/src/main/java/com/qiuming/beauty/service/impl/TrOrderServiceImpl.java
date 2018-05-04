/**
 * @(#) ${FILE_NAME} 1.0  2018:04:30
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.service.impl;

import com.qiuming.beauty.constants.Constants;
import com.qiuming.beauty.constants.OrderStatusEnum;
import com.qiuming.beauty.dto.*;
import com.qiuming.beauty.eo.*;
import com.qiuming.beauty.repository.*;
import com.qiuming.beauty.service.ICommentService;
import com.qiuming.beauty.service.ITrOderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: 订单service
 * @author: ji.shamo
 * @create: 2018-04-30 17:39
 **/
@Service("trOrderService")
public class TrOrderServiceImpl implements ITrOderService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Resource
    private TrOrderRepository trOrderRepository;
    @Resource
    private ItItemRepository itItemRepository;
    @Resource
    private ShopBarberRepository shopBarberRepository;
    @Resource
    private ItShopRepository itShopRepository;
    @Resource
    private ICommentService commentService;
    @Resource
    private ConfigRepository configRepository;

    @Override
    public AppToPayOrderRespDto submitOrder(OrderSubmitDto dto) {
        TrOrderEo orderEo = new TrOrderEo();
        BeanUtils.copyProperties(dto, orderEo);
        orderEo.setOrderTime(new Date());
        orderEo.setOrderNo(getOrderNo());
        orderEo.setStatus(OrderStatusEnum.ORDER_STATUS_DEFAULT.getStatus());
        ItShopEo shopEo = itShopRepository.findOne(dto.getShopId());
        orderEo.setShopName(shopEo.getShopName());
        ItItemEo itItemEo = itItemRepository.findOne(dto.getItemId());
        if (null != itItemEo){
            orderEo.setItemName(itItemEo.getName());
        }
        trOrderRepository.save(orderEo);
        AppToPayOrderRespDto toPayOrderRespDto = new AppToPayOrderRespDto();
        toPayOrderRespDto.setOrderNo(orderEo.getOrderNo());
        toPayOrderRespDto.setIsPay(false);
        toPayOrderRespDto.setOrderId(orderEo.getId());
        toPayOrderRespDto.setPayAmount(orderEo.getPayAmount());
        return toPayOrderRespDto;
    }

    @Override
    public OrderDetailDto getOrderDetaii(Long orderId) {
        TrOrderEo orderEo = trOrderRepository.findOne(orderId);
        OrderDetailDto detailDto = new OrderDetailDto();
        BeanUtils.copyProperties(orderEo, detailDto);
        detailDto.setOrderTimeStr(null == orderEo.getOrderTime() ? null : sdf.format(orderEo.getOrderTime()));
        detailDto.setCancelTimeStr(null == orderEo.getCancelTime() ? null : sdf.format(orderEo.getCancelTime()));
        detailDto.setFinishTimeStr(null == orderEo.getFinishTime() ? null : sdf.format(orderEo.getFinishTime()));
        return detailDto;
    }

    @Override
    public List<OrderListDto> getOrderList(Integer status, Long memberId) {
//        return trOrderRepository.findAllByMemberId(memberId);
        List<OrderListDto> listDtos = new ArrayList<>();

        List<TrOrderEo> orderEoList;
        if (null != status) {
            orderEoList = trOrderRepository.findAllByMemberIdAndStatus(memberId, status);
        } else {
            orderEoList = trOrderRepository.findAllByMemberId(memberId);
        }
        if (!CollectionUtils.isEmpty(orderEoList)) {
            OrderListDto dto;
            ItItemEo itemEo;
            for (TrOrderEo item : orderEoList) {
                dto = new OrderListDto();
                BeanUtils.copyProperties(item, dto);
                List<SysUserCommentEo> list = commentService.findCommentBymemberIdAndOrderId(item.getId(), memberId);
                if (!CollectionUtils.isEmpty(list)) {
                    dto.setDoComment(false);
                } else {
                    dto.setDoComment(true);
                }
                dto.setOrderTimeStr(null == item.getOrderTime() ? null : sdf.format(item.getOrderTime()));
                dto.setCancelTimeStr(null == item.getCancelTime() ? null : sdf.format(item.getCancelTime()));
                dto.setFinishTimeStr(null == item.getFinishTime() ? null : sdf.format(item.getFinishTime()));
                itemEo = itItemRepository.findOne(item.getItemId());
                if (null != itemEo) {
                    dto.setItemImage(itemEo.getUrl1());
                    dto.setItemName(itemEo.getName());
                }
                listDtos.add(dto);
            }
        }
        return listDtos;
    }

    @Override
    public void payOrder(Long orderId) {
        TrOrderEo orderEo = trOrderRepository.findOne(orderId);
        orderEo.setStatus(OrderStatusEnum.ORDER_STATUS_PAY.getStatus());
        orderEo.setPayTime(new Date());
        trOrderRepository.save(orderEo);
        ItShopEo shopEo = itShopRepository.findOne(orderEo.getShopId());
        //店铺购买数量加1
        shopEo.setSaleCount(null == shopEo.getSaleCount() ? 1l : shopEo.getSaleCount() + 1l);
        if (null != orderEo.getBarberId()) {
            ItShopBarberEo shopBarberEo = shopBarberRepository.findOne(orderEo.getBarberId());
            shopBarberEo.setOrderCount(null == shopBarberEo.getOrderCount() ? 1 : shopBarberEo.getOrderCount() + 1);
            shopBarberEo.setTodayCount(null == shopBarberEo.getTodayCount() ? 1 : shopBarberEo.getTodayCount() + 1);
            shopBarberRepository.save(shopBarberEo);
        }
        itShopRepository.save(shopEo);
    }

    @Override
    public void cancelOrder(Long orderId) {
        TrOrderEo orderEo = trOrderRepository.findOne(orderId);
        if (!OrderStatusEnum.ORDER_STATUS_DEFAULT.getStatus().equals(orderEo.getStatus())) {
            throw new RuntimeException("订单不能取消");
        }
        orderEo.setStatus(OrderStatusEnum.ORDER_STATUS_CANCEL.getStatus());
        orderEo.setCancelTime(new Date());
        orderEo.setCancelType("不想要了");
        trOrderRepository.save(orderEo);
    }

    @Override
    public void finishOrder(Long orderId) {
        TrOrderEo orderEo = trOrderRepository.findOne(orderId);
        orderEo.setStatus(OrderStatusEnum.ORDER_STATUS_FINISH.getStatus());
        orderEo.setFinishTime(new Date());
        trOrderRepository.save(orderEo);
    }

    private String getOrderNo() {
        MaConfigEo configEo = configRepository.findByCode(Constants.ORDER_NUMBER_CODE);
        if (configEo == null){
            configEo = new MaConfigEo();
            configEo.setCode(Constants.ORDER_NUMBER_CODE);
            configEo.setLongValue(1l);
            configEo.setStatus(1);
        }
        Long number = null != configEo.getLongValue() ? configEo.getLongValue() : 1;
        logger.info("当前订单号1 | {}", number);
        String memberCnNo = "CN" + String.format("%08d", number);
        configEo.setLongValue(number + 1);
        configRepository.save(configEo);
        logger.info("当前订单号2 | {}", configEo.getLongValue());
        return memberCnNo;
    }

    private String getOrderPayFlowNo() {
        MaConfigEo configEo = configRepository.findByCode(Constants.PAY_FLOW_NO);
        if (configEo != null){
            configEo = new MaConfigEo();
            configEo.setCode(Constants.PAY_FLOW_NO);
            configEo.setLongValue(1l);
            configEo.setStatus(1);
        }
        String orderFlow = getCurrentTimeNum() + String.format("%03d", Constants.PAY_FLOW_NO);
        logger.info("当前订单号2 | {}", orderFlow);
        return orderFlow;
    }

    public static String getCurrentTimeNum() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Date d = new Date();
        return sdf.format(d).toString();
    }
}
