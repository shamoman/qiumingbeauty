/**
 * @(#) ${FILE_NAME} 1.0  2018:05:01
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @description: 评论新增Dto
 * @author: ji.shamo
 * @create: 2018-05-01 14:23
 **/
public class CommentAddDto extends BaseVo {

    private Long orderId;

    private String remark;

    private Long shopId;

    private Long accountId;

    private BigDecimal score;

    List<String> commentImage;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public List<String> getCommentImage() {
        return commentImage;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public void setCommentImage(List<String> commentImage) {
        this.commentImage = commentImage;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }
}
