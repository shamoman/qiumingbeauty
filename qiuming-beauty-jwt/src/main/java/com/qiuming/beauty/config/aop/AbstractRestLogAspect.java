/**
 * @(#) ${FILE_NAME} 1.0  2018:04:21
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.config.aop;

import com.alibaba.fastjson.JSON;
import com.qiuming.beauty.dto.RestResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.lang.reflect.UndeclaredThrowableException;

/**
 *
 * @description: aop
 * @author: ji.shamo
 * @create: 2018-04-21 11:42
 **/
public abstract class AbstractRestLogAspect {
    private static Logger logger = LoggerFactory.getLogger(AbstractRestLogAspect.class);

    public AbstractRestLogAspect() {
    }

    public abstract void restLogAop();

    @Around("restLogAop()")
    public Object aroundRestApi(ProceedingJoinPoint point) throws Throwable {
        return this.log(point);
    }

    private Object log(ProceedingJoinPoint point) throws Throwable {
        logger.info("日志统一打印 ===== {}.{}() start =====,参数:{}", new Object[]{point.getSignature().getDeclaringTypeName(), point.getSignature().getName(), this.argsToString(point.getArgs())});
        DateTime startTime = new DateTime();
        Object response = null;

        try {
            response = point.proceed();
        } catch (UndeclaredThrowableException var8) {
            logger.error("未知的异常", var8);
            response = new RestResponse(-1, var8.getMessage().replaceAll("Exception.*?]", ""), (Object)null);
        } catch (Exception var9) {
            logger.error("", var9);
            if (var9 instanceof RuntimeException) {
                if (!StringUtils.isEmpty(var9.getMessage()) && var9.getMessage().contains("TimeOutException")) {
                    response = new RestResponse(-1, "系统繁忙,请稍后重试！", (Object)null);
                } else {
                    response = new RestResponse(-1, var9.getMessage().replaceAll("Exception.*?]", ""), (Object)null);
                }
            } else {
                response = new RestResponse(-1, "系统繁忙,请稍后重试！", (Object)null);
            }
        }
        DateTime endTime = new DateTime();
        Interval interval = new Interval(startTime, endTime);
        logger.info("日志统一打印 ===== {}.{}() end =====,响应时间:{}毫秒,响应内容:{}", new Object[]{point.getSignature().getDeclaringTypeName(), point.getSignature().getName(), interval.toDurationMillis(), this.argsToString(response)});
        return response;
    }


    private String argsToString(Object object) {
        try {
            return null == object ? "" : JSON.toJSONString(object);
        } catch (Exception var3) {
            logger.error("", var3);
            return String.valueOf(object);
        }
    }
}
