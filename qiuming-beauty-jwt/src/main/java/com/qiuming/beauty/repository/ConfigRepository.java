/**
 * @(#) ${FILE_NAME} 1.0  2018:05:04
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.repository;

import com.qiuming.beauty.eo.MaConfigEo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @description: 配置项
 * @author: ji.shamo
 * @create: 2018-05-04 12:13
 **/
public interface ConfigRepository  extends JpaRepository<MaConfigEo, Long> {

    /**
     * 根据code查询
     * @param code - 编码
     * @return
     */
    MaConfigEo findByCode(String code);
}
