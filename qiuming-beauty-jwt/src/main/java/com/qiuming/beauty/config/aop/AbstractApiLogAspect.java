/**
 * @(#) ${FILE_NAME} 1.0  2018:04:21
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.config.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @description: 日志
 * @author: ji.shamo
 * @create: 2018-04-21 11:34
 **/
public abstract class AbstractApiLogAspect {
    private static Logger logger = LoggerFactory.getLogger(AbstractApiLogAspect.class);

    public AbstractApiLogAspect() {
    }

    public abstract void apiLogAop();

    @Around("apiLogAop()")
    public Object aroundApi(ProceedingJoinPoint point) throws Throwable {
        return this.log(point);
    }

    private Object log(ProceedingJoinPoint point) throws Throwable {
        logger.info("日志统一打印 ===== {}.{}() start =====,参数:{}", new Object[]{point.getSignature().getDeclaringTypeName(), point.getSignature().getName(), this.argsToString(point.getArgs())});
        DateTime startTime = new DateTime();
        DateTime endTime = null;
        Interval interval = null;
        Object response = null;

        try {
            response = point.proceed();
        } catch (Exception var7) {
            logger.error("", var7);
            endTime = new DateTime();
            interval = new Interval(startTime, endTime);
            logger.info("日志统一打印 ===== {}.{}() end =====,响应时间:{}毫秒,响应内容:{}", new Object[]{point.getSignature().getDeclaringTypeName(), point.getSignature().getName(), interval.toDurationMillis()});
            throw var7;
        }

        endTime = new DateTime();
        interval = new Interval(startTime, endTime);
        logger.info("日志统一打印 ===== {}.{}() end =====,响应时间:{}毫秒,响应内容:{}", new Object[]{point.getSignature().getDeclaringTypeName(), point.getSignature().getName(), interval.toDurationMillis(), this.argsToString(response)});
        return response;
    }

    private String argsToString(Object object) {
        try {
            return JSON.toJSONString(object);
        } catch (Exception var3) {
            logger.error("", var3);
            return String.valueOf(object);
        }
    }
}
