package com.xhs.first.service;

import com.xhs.first.pojo.OrderItem;
import com.xhs.first.pojo.ShopOrder;

import java.util.List;

public interface OrderService {

    int createOrder(ShopOrder shopOrder);

    int deleteOrderById(int orderId);

}
