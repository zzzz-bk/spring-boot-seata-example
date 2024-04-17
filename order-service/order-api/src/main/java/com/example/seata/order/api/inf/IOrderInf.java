package com.example.seata.order.api.inf;

import com.example.seata.account.common.dto.OrderDto;
import com.example.seata.account.common.response.ObjectResponse;

/**
 * @author anisa
 */
public interface IOrderInf {
    /**
     * 创建订单
     * @param orderDto order数据对象
     * @return 响应
     */
    ObjectResponse<OrderDto> createOrder(OrderDto orderDto);
}
