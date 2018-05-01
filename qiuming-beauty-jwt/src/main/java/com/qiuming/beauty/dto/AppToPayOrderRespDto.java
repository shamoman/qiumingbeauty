package com.qiuming.beauty.dto;


import java.math.BigDecimal;
import java.util.Map;

/**
 * 提交订单支付信息
 */
public class AppToPayOrderRespDto extends BaseVo {
    /**
     * 返回code
     */
    private int resultCode = 0;
    /**
     * 返回信息
     */
    private String resultMsg;
    /**
     * 返回参数
     */
    private Map<String, String> data;

    private String url;
    /**
     * app 调用的url
     */
    private String appInvoking;
    /**
     * 支付方式
     */
    private String payMethod;
    /**
     * 订单支付流水号
     */
    private String payNo = "P0000000";


    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 订单编码
     */
    private String orderNo = "";

    /**
     * 订单的配置支付流水
     */
    private String orderShowPayNo;

    /**
     * 订单总金额
     */
    private BigDecimal payAmount = new BigDecimal(0);

    /**
     * 支付结束时间
     */
    private String payEndTime;
    /**
     * 是否支付
     */
    private boolean isPay = true;


    /**
     * 查询支付结果的次数
     */
    private Integer queryPayResultNum = 0;




    public String getOrderShowPayNo() {
        return orderShowPayNo;
    }

    public void setOrderShowPayNo(String orderShowPayNo) {
        this.orderShowPayNo = orderShowPayNo;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayEndTime() {
        return payEndTime;
    }

    public void setPayEndTime(String payEndTime) {
        this.payEndTime = payEndTime;
    }

    public boolean getIsPay() {
        return isPay;
    }

    public void setIsPay(boolean isPay) {
        this.isPay = isPay;
    }

    public int getResultCode() {
        return resultCode;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public boolean isPay() {
        return isPay;
    }

    public void setPay(boolean pay) {
        isPay = pay;
    }

    public Integer getQueryPayResultNum() {
        return queryPayResultNum;
    }

    public void setQueryPayResultNum(Integer queryPayResultNum) {
        this.queryPayResultNum = queryPayResultNum;
    }

    public String getUrl() {
        return url;
    }

    public String getAppInvoking() {
        return appInvoking;
    }

    public void setAppInvoking(String appInvoking) {
        this.appInvoking = appInvoking;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
