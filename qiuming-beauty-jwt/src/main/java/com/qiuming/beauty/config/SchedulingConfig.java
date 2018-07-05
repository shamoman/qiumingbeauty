/**
 * @(#) ${FILE_NAME} 1.0  2018:05:01
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.config;

import com.alibaba.fastjson.JSON;
import com.qiuming.beauty.constants.OrderStatusEnum;
import com.qiuming.beauty.eo.TrOrderEo;
import com.qiuming.beauty.repository.TrOrderRepository;
import com.qiuming.beauty.service.ITrOderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import javax.xml.bind.util.JAXBSource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @description: 定时任务
 * @author: ji.shamo
 * @create: 2018-05-01 23:20
 **/
@Configuration
@EnableScheduling
public class SchedulingConfig {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private TrOrderRepository trOrderRepository;

//    @Scheduled(cron = "0 0/10 * * * ?") // 每2分钟执行一次
//    public void getToken() {
//        logger.info("取消订单----定时任务启动");
//        Date date = new Date(new Date().getTime() - 2 * 60 *1000);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        logger.info("取消时间 | {}", sdf.format(date));
//
//        List<TrOrderEo> orderEoList = trOrderRepository.findAllByStatusAndOrderTimeBefore(OrderStatusEnum.ORDER_STATUS_DEFAULT.getStatus(), date);
//        logger.info("要取消的订单 | {}", JSON.toJSONString(orderEoList));
//        for (TrOrderEo item : orderEoList){
//            item.setStatus(OrderStatusEnum.ORDER_STATUS_CANCEL.getStatus());
//            item.setCancelTime(new Date());
//            item.setCancelType("长时间未支付");
//            trOrderRepository.save(item);
//        }
//    }
}
