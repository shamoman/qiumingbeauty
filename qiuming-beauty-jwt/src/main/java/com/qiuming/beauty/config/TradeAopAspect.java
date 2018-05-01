/**
 * @(#) TradeCoreAopAspect.java 1.0 2017-09-14
 * Copyright (c) 2017, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.config;

import com.qiuming.beauty.config.aop.AbstractRestLogAspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

/**
 * 日志记录
 *
 * @author 魄罗
 * @since 0.5.0
 */
@Aspect
@Order(3)
public class TradeAopAspect extends AbstractRestLogAspect {

    @Override
    @Pointcut("execution (public * com.qiuming.beauty.controller.*.*(..))")
    public void restLogAop() {

    }
}
