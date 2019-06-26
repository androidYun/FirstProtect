package com.xhs.first.dao;

import com.xhs.first.pojo.ItemCart;

import java.util.List;

public interface ItemCartMapper {
    int deleteByPrimaryKey(Integer cartItemId);

    int insert(ItemCart record);

    int insertSelective(ItemCart record);

    ItemCart selectByPrimaryKey(Integer cartItemId);

    int insertItemCartList(List<ItemCart> itemCartLIst);

    int deleteItemCartByCartId(int cartId);

    int updateByPrimaryKeySelective(ItemCart record);

    int updateByPrimaryKey(ItemCart record);
}