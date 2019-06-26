package com.xhs.first.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ItemOrderDetailEntity {
    private Integer itemOrderId;

    private Integer orderId;

    private Integer protectId;

    private Date createTime;

    private BigDecimal itemAmount;

    private Integer number;

    private Integer groupId;

    private String protectName;

    private BigDecimal price;

    private String imageUrl;

    private Integer saleNumber;

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

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getProtectName() {
        return protectName;
    }

    public void setProtectName(String protectName) {
        this.protectName = protectName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(Integer saleNumber) {
        this.saleNumber = saleNumber;
    }
}
