package com.example.seata.order.provider.impl;

import com.example.seata.account.api.inf.IAccountService;
import com.example.seata.account.common.constants.ResCode;
import com.example.seata.account.common.dto.AccountDto;
import com.example.seata.account.common.dto.OrderDto;
import com.example.seata.account.common.response.ObjectResponse;
import com.example.seata.order.api.inf.IOrderInf;
import com.example.seata.order.provider.convert.OrderConvert;
import com.example.seata.order.provider.dal.entitys.Order;
import com.example.seata.order.provider.dal.mappers.OrderMapper;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * @Author: Zhengyb
 * @Date: 2024/4/13 10:54
 **/
@Service
@Slf4j
public class OrderServiceImpl implements IOrderInf {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderConvert orderConvert;
    @Reference
    private IAccountService accountService;
    @Override
    public ObjectResponse<OrderDto> createOrder(OrderDto orderDto) {
        log.info("全局事务id：{}",RootContext.getXID());
        ObjectResponse<OrderDto> response = new ObjectResponse<>();
        try {
            //扣款
            AccountDto accountDto = new AccountDto();
            accountDto.setUserId(orderDto.getUserId());
            accountDto.setBalance(orderDto.getOrderAmount());
            ObjectResponse decreaseResp = accountService.decreaseAccount(accountDto);
            if(decreaseResp.getCode()!= ResCode.SUCCESS.getCode()){
                response.setCode(ResCode.FAILED.getCode());
                response.setMsg(ResCode.FAILED.getMessage());
                return response;
            }
            //创建订单
            Order order = orderConvert.dto2Order(orderDto);
            order.setOrderNo(UUID.randomUUID().toString());
            orderMapper.createOrder(order);
            response.setCode(ResCode.SUCCESS.getCode());
            response.setMsg(ResCode.SUCCESS.getMessage());
        } catch (Exception e){
            log.error("create order occur error:",e);
            response.setCode(ResCode.SYSTEM_EXCEPTION.getCode());
            response.setMsg(ResCode.SYSTEM_EXCEPTION.getMessage()+"-"+e.getMessage());
        }
        return response;
    }
}
