/**
 * @(#) TradeAopConfig.java 1.0 2017-11-10
 * Copyright (c) 2017, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * aop配置
 *
 * @since 0.2.0
 */
@Configuration
public class TradeAopConfig {

    @Bean
    public TradeAopAspect logHandler() {
        return new TradeAopAspect();
    }

}
