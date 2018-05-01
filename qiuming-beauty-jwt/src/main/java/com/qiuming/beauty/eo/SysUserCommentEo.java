/**
 * @(#)${file_name} 1.0  2018:04:19
 * <p>
 * Copyright (c) 2017, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.eo;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 *
 * @description: 用户评论表
 * @author: ji.shamo
 * @create: 2018-04-19 23:27
 **/
@Entity
@Table(name = "sys_user_comment")
public class SysUserCommentEo extends BaseEo {

    @Column(name = "account_id")
    private Long accountId;
    @Column(name = "shop_id")
    private Long shopId;
    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "item_id")
    private Long itemId;
    @Column(name = "item_name")
    private Long itemName;
    @Column(name = "item_title")
    private String itemTitle;
    @Column(name = "remark")
    private String remark;
    @Column(name = "content")
    private String content;
    @Column(name = "score")
    private BigDecimal score;
    @Column(name = "url1")
    private String url1;
    @Column(name = "url2")
    private String url2;
    @Column(name = "url3")
    private String url3;
    @Id
    @GeneratedValue
    private Long id;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getItemName() {
        return itemName;
    }

    public void setItemName(Long itemName) {
        this.itemName = itemName;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    public String getUrl3() {
        return url3;
    }

    public void setUrl3(String url3) {
        this.url3 = url3;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
