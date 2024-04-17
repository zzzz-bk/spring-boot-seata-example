package com.example.seata.order.provider.convert;

import com.example.seata.account.common.dto.OrderDto;
import com.example.seata.order.provider.dal.entitys.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Order类转换器
 *
 * @author anisa
 */
@Mapper(componentModel = "spring")
public interface OrderConvert {

    /**
     * 转换方法
     *
     * @param dto 数据对象
     * @return Order对象
     */
    @Mappings({
            @Mapping(source = "orderCount", target = "count"),
            @Mapping(source = "orderAmount", target = "amount")
    })
    Order dto2Order(OrderDto dto);
}
