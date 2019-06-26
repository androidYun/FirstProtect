package com.xhs.first.service.impl;

import com.xhs.first.dao.ItemCartMapper;
import com.xhs.first.dao.ShopCartMapper;
import com.xhs.first.pojo.ShopCart;
import com.xhs.first.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import java.util.List;

@Service
public class ShopCartServiceImpl implements ShopCartService {

    @Autowired
    ShopCartMapper shopCartMapper;

    @Autowired
    ItemCartMapper itemCartMapper;

    public ShopCart selectById(int cartId) {
        return shopCartMapper.selectByPrimaryKey(cartId);
    }

    public int insertShopCart(ShopCart shopCart) {
        return shopCartMapper.insert(shopCart);
    }

    @Transient
    public int deleteShopCart(int shopCartId) {
        int deleteCartCount = shopCartMapper.deleteByPrimaryKey(shopCartId);
        int deleteItemCartCount = itemCartMapper.deleteItemCartByCartId(shopCartId);
        return deleteCartCount;
    }

    public List<ShopCart> getShopCartListById(int userId) {
        return shopCartMapper.getShopCartListById(userId);
    }
}
