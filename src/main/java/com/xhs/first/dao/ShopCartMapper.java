package com.xhs.first.dao;

import com.xhs.first.pojo.ShopCart;

import java.util.List;

public interface ShopCartMapper {
    int deleteByPrimaryKey(Integer cartId);

    int insert(ShopCart record);

    int insertSelective(ShopCart record);

    ShopCart selectByPrimaryKey(Integer cartId);

    List<ShopCart> getShopCartListById(Integer userId);

    int updateByPrimaryKeySelective(ShopCart record);

    int updateByPrimaryKey(ShopCart record);
}