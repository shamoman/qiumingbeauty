/**
 * @(#) ${FILE_NAME} 1.0  2018:05:04
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.eo;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 *
 * @description: 配置项
 * @author: ji.shamo
 * @create: 2018-05-04 12:06
 **/

@Entity
@Table(name = "ma_config")
public class MaConfigEo extends BaseEo {

    @Id
    @GeneratedValue
    private Long id;
    /**
     * 配置编码
     */
    @Column(name = "code")
    private String code;
    /**
     * 配置内容
     */
    @Column(name = "value")
    private byte[] value;

    @Column(name = "long_value")
    private Long longValue;

    /**
     * 0 停用 1 启用
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public byte[] getValue() {
        return value;
    }

    public void setValue(byte[] value) {
        this.value = value;
    }

    public Long getLongValue() {
        return longValue;
    }

    public void setLongValue(Long longValue) {
        this.longValue = longValue;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
