package com.xhs.first.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class OrderItem {
    private Integer itemOrderId;

    private Integer orderId;

    private Integer protectId;

    private Date createTime;

    private BigDecimal itemAmount;

    private Integer number;

    public Integer getItemOrderId() {
        return itemOrderId;
    }

    public void setItemOrderId(Integer itemOrderId) {
        this.itemOrderId = itemOrderId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProtectId() {
        return protectId;
    }

    public void setProtectId(Integer protectId) {
        this.protectId = protectId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(BigDecimal itemAmount) {
        this.itemAmount = itemAmount;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}