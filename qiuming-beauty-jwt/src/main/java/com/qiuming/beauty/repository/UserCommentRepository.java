/**
 * @(#)$1.0  2018:04:20
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.repository;

import com.qiuming.beauty.eo.SysUserCommentEo;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 * @description: 用户评论Repository
 * @author: ji.shamo
 * @create: 2018-04-20 21:02
 **/
public interface UserCommentRepository extends JpaRepository<SysUserCommentEo, Long> {
    /**
     * 根据店铺id查询店铺的评论列表
     * @param shopId - 店铺id
     * @return
     */
    List<SysUserCommentEo> findAllByShopId(Long shopId, Sort sort);

    /**
     * 查询用户是否已评论该订单
     * @param accountId - 用户id
     * @param orderId - 订单id
     * @return
     */
    List<SysUserCommentEo> findAllByAccountIdAndOrderId(Long accountId, Long orderId);
}
