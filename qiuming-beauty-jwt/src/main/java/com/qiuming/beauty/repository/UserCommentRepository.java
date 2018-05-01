/**
 * @(#)$1.0  2018:04:20
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.repository;

import com.qiuming.beauty.eo.SysUserCommentEo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @description: 用户评论Repository
 * @author: ji.shamo
 * @create: 2018-04-20 21:02
 **/
public interface UserCommentRepository extends JpaRepository<SysUserCommentEo, Long> {
}
