/**
 * @(#) ${FILE_NAME} 1.0  2018:04:22
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.repository;

import com.qiuming.beauty.eo.SysUserInfoEo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @description: 用户详情repository
 * @author: ji.shamo
 * @create: 2018-04-22 12:15
 **/
public interface SysUserInfoRepository extends JpaRepository<SysUserInfoEo, Long> {

    SysUserInfoEo findSysUserInfoEoByAccountId(Long accountId);
}
