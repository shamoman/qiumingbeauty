/**
 * @(#)${file_name} 1.0  2018:04:18
 * <p>
 * Copyright (c) 2017, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.dto;

/**
 *
 * @description: 接口返回对象
 * @author: ji.shamo
 * @create: 2018-04-18 22:02
 **/
public class RestResponse {
    private int resultCode;
    private String resultMsg;
    private Object data;
    public static final RestResponse SUCCESS = new RestResponse();

    public RestResponse() {
        this((Object)null);
    }

    public RestResponse(Object data) {
        this.resultCode = 0;
        this.resultMsg = "success";
        this.data = data;
    }

    public RestResponse(int resultCode, String resutMessage) {
        this.resultCode = resultCode;
        this.resultMsg = resutMessage;
    }

    public RestResponse(int resultCode, String resutMsg, Object data) {
        this.resultCode = resultCode;
        this.resultMsg = resutMsg;
        this.data = data;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String toString() {
        return "RestResponse [resultCode=" + this.resultCode + ", resultMsg=" + this.resultMsg + ", data=" + this.data + "]";
    }
}
