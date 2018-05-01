/**
 * @(#) ${FILE_NAME} 1.0  2018:04:30
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.service.impl;

import com.qiuming.beauty.constants.Constants;
import com.qiuming.beauty.dto.AppToPayOrderRespDto;
import com.qiuming.beauty.dto.OrderDetailDto;
import com.qiuming.beauty.dto.OrderListDto;
import com.qiuming.beauty.dto.OrderSubmitDto;
import com.qiuming.beauty.eo.ItItemEo;
import com.qiuming.beauty.eo.ItShopBarberEo;
import com.qiuming.beauty.eo.ItShopEo;
import com.qiuming.beauty.eo.TrOrderEo;
import com.qiuming.beauty.repository.ItItemRepository;
import com.qiuming.beauty.repository.ItShopRepository;
import com.qiuming.beauty.repository.ShopBarberRepository;
import com.qiuming.beauty.repository.TrOrderRepository;
import com.qiuming.beauty.service.ITrOderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @description: 订单service
 * @author: ji.shamo
 * @create: 2018-04-30 17:39
 **/
@Service("trOrderService")
public class TrOrderServiceImpl implements ITrOderService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private TrOrderRepository trOrderRepository;
    @Resource
    private ItItemRepository itItemRepository;
    @Resource
    private ShopBarberRepository shopBarberRepository;
    @Resource
    private ItShopRepository itShopRepository;

    @Override
    public AppToPayOrderRespDto submitOrder(OrderSubmitDto dto) {
        TrOrderEo orderEo = new TrOrderEo();
        BeanUtils.copyProperties(dto, orderEo);
        orderEo.setOrderTime(new Date());
        orderEo.setOrderNo(getOrderNo());
        orderEo.setStatus(0);
        ItShopEo shopEo = itShopRepository.findOne(dto.getShopId());
        orderEo.setShopName(shopEo.getShopName());
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
       return detailDto;
    }

    @Override
    public List<OrderListDto> getOrderList(Long memberId) {
//        return trOrderRepository.findAllByMemberId(memberId);
        List<OrderListDto> listDtos = new ArrayList<>();
        List<TrOrderEo> orderEoList = trOrderRepository.findAll();
        if (!CollectionUtils.isEmpty(orderEoList)){
            OrderListDto dto;
            ItItemEo itemEo;
            for (TrOrderEo item : orderEoList){
                dto = new OrderListDto();
                BeanUtils.copyProperties(item, dto);
                itemEo = itItemRepository.findOne(item.getItemId());
                if (null != itemEo){
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
        orderEo.setStatus(2);
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

    private String getOrderNo(){
        logger.info("当前订单号1 | {}", Constants.ORDER_NUMBER);
        String memberCnNo = "CN" + String.format("%08d", Constants.ORDER_NUMBER);
        Constants.setOrderNumber(Constants.ORDER_NUMBER ++);
        logger.info("当前订单号2 | {}", Constants.ORDER_NUMBER);
        return memberCnNo;
    }

    private String getOrderPayFlowNo(){
        String orderFlow = getCurrentTimeNum() + String.format("%03d", Constants.ORDER_NUMBER);
        logger.info("当前订单号2 | {}", orderFlow);
        return orderFlow;
    }
    public static String getCurrentTimeNum() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Date d = new Date();
        return sdf.format(d).toString();
    }
}
