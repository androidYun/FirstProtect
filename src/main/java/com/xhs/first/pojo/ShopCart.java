package com.xhs.first.pojo;

import com.xhs.first.entity.ItemCartDetailEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ShopCart {
    private Integer cartId;

    private Integer userId;

    private Date createTime;

    private BigDecimal amount;

    private List<ItemCartDetailEntity> itemCartList;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public List<ItemCartDetailEntity> getItemCartList() {
        return itemCartList;
    }

    public void setItemCartList(List<ItemCartDetailEntity> itemCartList) {
        this.itemCartList = itemCartList;
    }
}