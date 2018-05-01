/**
 * @(#) ${FILE_NAME} 1.0  2018:05:01
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.service;

import com.qiuming.beauty.dto.CommentAddDto;
import com.qiuming.beauty.eo.SysUserCommentEo;

import java.util.List;

/**
 *
 * @description: 评论service接口
 * @author: ji.shamo
 * @create: 2018-05-01 13:47
 **/
public interface ICommentService {
    /**
     *
     * @param addDto - 评论实体
     */
    void addComment(CommentAddDto addDto);

    List<SysUserCommentEo> findCommentList(Long shopId);
}
