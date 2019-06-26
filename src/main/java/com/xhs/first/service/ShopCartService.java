package com.xhs.first.service;

import com.xhs.first.pojo.ShopCart;

import java.util.List;

public interface ShopCartService {

    ShopCart selectById(int cartId);

    List<ShopCart> getShopCartListById(int userId);

    int insertShopCart(ShopCart shopCart);

    int deleteShopCart(int shopCartId);
}
