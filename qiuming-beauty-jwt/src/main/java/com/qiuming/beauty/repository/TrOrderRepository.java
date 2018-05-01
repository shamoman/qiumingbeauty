/**
 * @(#) ${FILE_NAME} 1.0  2018:04:23
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.repository;

import com.qiuming.beauty.eo.TrOrderEo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 * @description: 订单Repository
 * @author: ji.shamo
 * @create: 2018-04-23 23:51
 **/
public interface TrOrderRepository  extends JpaRepository<TrOrderEo, Long> {
    /**
     * 根据用户id查询订单列表
     * @param memberId - 用户id
     * @return
     */
    List<TrOrderEo> findAllByMemberId(Long memberId);
}
