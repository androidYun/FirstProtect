package com.xhs.first.entity;

import java.util.List;

public class CreateOrder {

    List<ProtectEntity> protectEntities;


    int cartId;

    public List<ProtectEntity> getProtectEntities() {
        return protectEntities;
    }

    public void setProtectEntities(List<ProtectEntity> protectEntities) {
        this.protectEntities = protectEntities;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
}
