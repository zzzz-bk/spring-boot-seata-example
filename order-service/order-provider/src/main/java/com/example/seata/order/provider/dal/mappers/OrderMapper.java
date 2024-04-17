package com.example.seata.order.provider.dal.mappers;

import com.example.seata.order.provider.dal.entitys.Order;

/**
 * @author anisa
 */
public interface OrderMapper {
    /**
     * 创建订单
     * @param order 订单
     */
    void createOrder(Order order);
}
