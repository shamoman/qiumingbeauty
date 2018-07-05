/**
 * @(#) ${FILE_NAME} 1.0  2018:05:01
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.service.impl;

import com.qiuming.beauty.domain.SysUser;
import com.qiuming.beauty.dto.CommentAddDto;
import com.qiuming.beauty.eo.ItShopEo;
import com.qiuming.beauty.eo.SysUserCommentEo;
import com.qiuming.beauty.eo.SysUserInfoEo;
import com.qiuming.beauty.eo.TrOrderEo;
import com.qiuming.beauty.repository.ItShopRepository;
import com.qiuming.beauty.repository.SysUserInfoRepository;
import com.qiuming.beauty.repository.SysUserRepository;
import com.qiuming.beauty.repository.UserCommentRepository;
import com.qiuming.beauty.service.ICommentService;
import com.qiuming.beauty.service.ITrOderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @description: 评论service实现类
 * @author: ji.shamo
 * @create: 2018-05-01 13:48
 **/
@Service("commentService")
public class CommentServiceImpl implements ICommentService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserCommentRepository userCommentRepository;
    @Resource
    private ItShopRepository itShopRepository;
    @Resource
    private SysUserRepository sysUserRepository;
    @Resource
    private SysUserInfoRepository sysUserInfoRepository;
    @Resource
    private ITrOderService trOderService;

    @Override
    public void addComment(CommentAddDto commentAddDto) {
        SysUserCommentEo commentEo = new SysUserCommentEo();
        BeanUtils.copyProperties(commentAddDto, commentEo);
        commentEo.setCreateTime(new Date());
        // 更新店铺评分
        ItShopEo shopEo = itShopRepository.findOne(commentAddDto.getShopId());
        BigDecimal score = null == shopEo.getCommentScore() ? new BigDecimal(0 ): shopEo.getCommentScore().multiply(new BigDecimal(shopEo.getCommentCount()));
        shopEo.setCommentCount((null == shopEo.getCommentCount() || 0 == shopEo.getCommentCount())? 1 : shopEo.getCommentCount()+ 1l );
        BigDecimal scoreAdded =  score.add(commentAddDto.getScore());
        logger.info("score | {}, scoreAdded | {} commentCount | {}", score, scoreAdded, shopEo.getCommentCount());
        BigDecimal scoreDivied = scoreAdded.divide(new BigDecimal(shopEo.getCommentCount()));
        shopEo.setCommentScore(scoreDivied);
        shopEo.setCommentCount(null == shopEo.getCommentCount() ? 1 : shopEo.getCommentCount() + 1);
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
        SysUser sysUser = sysUserRepository.findOne(commentAddDto.getAccountId());
        commentEo.setUserName(sysUser.getUsername());
        commentEo.setCreateTime(new Date());
        TrOrderEo trOrderEo = trOderService.getOrderDetaii(commentAddDto.getOrderId());
        commentEo.setItemName(null != trOrderEo ? trOrderEo.getItemName() : null);
        itShopRepository.save(shopEo);
        userCommentRepository.save(commentEo);
    }

    private List<String> getCommentImages(SysUserCommentEo commentEo){
        List<String> environmentImagelist= new ArrayList<>();
        if (!StringUtils.isEmpty(commentEo.getUrl1()))
            environmentImagelist.add(commentEo.getUrl1());
        if (!StringUtils.isEmpty(commentEo.getUrl2()))
            environmentImagelist.add(commentEo.getUrl2());
        if (!StringUtils.isEmpty(commentEo.getUrl3()))
            environmentImagelist.add(commentEo.getUrl3());
        return environmentImagelist;
    }
    private List<CommentAddDto> transCommenttos(List<SysUserCommentEo> list){
        List<CommentAddDto> listDtos = new ArrayList<>();
        if (!CollectionUtils.isEmpty(list)){
            CommentAddDto dto;
            for (SysUserCommentEo item : list){
                dto = new CommentAddDto();
                BeanUtils.copyProperties(item, dto);
                dto.setCommentImage(getCommentImages(item));
                SysUserInfoEo infoEo = sysUserInfoRepository.findSysUserInfoEoByAccountId(item.getAccountId());
                dto.setAvatarUrl(infoEo != null ? infoEo.getAvatarUrl() : null);
                listDtos.add(dto);
            }
        }
        return listDtos;
    }

    @Override
    public List<CommentAddDto> findCommentList(Long shopId) {
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC,"id"));
        List<SysUserCommentEo> commentEos = userCommentRepository.findAllByShopId(shopId, sort);

        return transCommenttos(commentEos);
    }

    @Override
    public List<SysUserCommentEo> findCommentBymemberIdAndOrderId(Long orderId, Long memberId) {
        return userCommentRepository.findAllByAccountIdAndOrderId(memberId, orderId);
    }
}
