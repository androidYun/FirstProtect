package com.xhs.first.dao;

import com.xhs.first.pojo.ShopOrder;

import java.util.List;

public interface ShopOrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(ShopOrder record);

    int insertSelective(ShopOrder record);

    ShopOrder selectByPrimaryKey(Integer orderId);

    List<ShopOrder> selectOrderListByUserId(Integer userId);

    int updateByPrimaryKeySelective(ShopOrder record);

    int updateByPrimaryKey(ShopOrder record);
}