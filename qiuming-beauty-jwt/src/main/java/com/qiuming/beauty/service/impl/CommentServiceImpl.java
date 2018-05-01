/**
 * @(#) ${FILE_NAME} 1.0  2018:05:01
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.service.impl;

import com.qiuming.beauty.dto.CommentAddDto;
import com.qiuming.beauty.eo.ItShopEo;
import com.qiuming.beauty.eo.SysUserCommentEo;
import com.qiuming.beauty.repository.ItShopRepository;
import com.qiuming.beauty.repository.UserCommentRepository;
import com.qiuming.beauty.service.ICommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @description: 评论service实现类
 * @author: ji.shamo
 * @create: 2018-05-01 13:48
 **/
@Service("commentService")
public class CommentServiceImpl implements ICommentService {

    @Resource
    private UserCommentRepository userCommentRepository;
    @Resource
    private ItShopRepository itShopRepository;

    @Override
    public void addComment(CommentAddDto commentAddDto) {
        SysUserCommentEo commentEo = new SysUserCommentEo();
        BeanUtils.copyProperties(commentAddDto, commentEo);
        // 更新店铺评分
        ItShopEo shopEo = itShopRepository.findOne(commentAddDto.getShopId());
        shopEo.setCommentCount(null == shopEo.getCommentCount() ? 1 : shopEo.getCommentCount()+ 1l );
        BigDecimal score = shopEo.getCommentScore();
        BigDecimal scoreAdded =  score.add(commentAddDto.getScore());
        BigDecimal scoreDivied = scoreAdded.divide(new BigDecimal(shopEo.getCommentCount()));
        shopEo.setCommentScore(scoreDivied);
        List<String> images = commentAddDto.getCommentImage();
        if (!CollectionUtils.isEmpty(images)) {
            for (int i =0 ; i < images.size(); i++) {
                if (i == 0){
                    commentEo.setUrl1(images.get(0));
                }else if (i == 1){
                    commentEo.setUrl2(images.get(1));
                }else if (i == 2){
                    commentEo.setUrl3(images.get(2));
                }
            }
        }
        userCommentRepository.save(commentEo);
    }

    @Override
    public List<SysUserCommentEo> findCommentList(Long shopId) {

        return null;
    }
}
