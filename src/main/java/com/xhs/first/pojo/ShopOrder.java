package com.xhs.first.pojo;

import com.xhs.first.entity.ItemOrderDetailEntity;

import java.util.Date;
import java.util.List;

public class ShopOrder {
    private Integer orderId;

    private Integer number;

    private Long amount;

    private Date createTime;

    private Integer state;

    private Integer userId;

    private List<ItemOrderDetailEntity> detailEntityList;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<ItemOrderDetailEntity> getDetailEntityList() {
        return detailEntityList;
    }

    public void setDetailEntityList(List<ItemOrderDetailEntity> detailEntityList) {
        this.detailEntityList = detailEntityList;
    }
}