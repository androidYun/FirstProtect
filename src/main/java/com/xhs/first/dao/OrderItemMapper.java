package com.xhs.first.dao;

import com.xhs.first.pojo.OrderItem;

import java.util.List;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer itemOrderId);
    int deleteByOrderId(Integer orderId);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    int insertOrderItemList(List<OrderItem> orderItemList);

    OrderItem selectByPrimaryKey(Integer itemOrderId);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);
}