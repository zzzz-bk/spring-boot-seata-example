package com.example.seata.web.service;

import com.example.seata.account.common.constants.ResCode;
import com.example.seata.account.common.dto.OrderDto;
import com.example.seata.account.common.dto.OrderRequest;
import com.example.seata.account.common.dto.ProductDto;
import com.example.seata.account.common.response.ObjectResponse;
import com.example.seata.order.api.inf.IOrderInf;
import com.example.seata.repo.api.inf.IRepoService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @Author: Zhengyb
 * @Date: 2024/4/13 23:50
 **/
@Service
@Slf4j
public class IRestOrderServiceImpl implements IRestOrderService {
    @Reference(timeout = 5000)
    private IOrderInf orderService;
    @Reference(timeout = 5000)
    private IRepoService repoService;
    @GlobalTransactional(timeoutMills = 300000,name = "rest-web")
    @Override
    public ObjectResponse handleBusiness(OrderRequest request) throws Exception {
        log.info("全局事务id:{}", RootContext.getXID());
        log.info("begin order:{}",request);
        ProductDto productDto = new ProductDto();
        productDto.setProductCode(request.getProductCode());
        productDto.setCount(request.getCount());
        ObjectResponse repoResp = repoService.decreaseRepo(productDto);
        OrderDto orderDto = new OrderDto();
        orderDto.setUserId(request.getUserId());
        orderDto.setProductCode(request.getProductCode());
        orderDto.setOrderCount(request.getCount());
        orderDto.setOrderAmount(request.getAmount());
        ObjectResponse orderResp = orderService.createOrder(orderDto);
        ObjectResponse response = new ObjectResponse();
        response.setCode(ResCode.SUCCESS.getCode());
        response.setMsg(ResCode.SUCCESS.getMessage());
        response.setData(orderResp.getData());
        return response;
    }
}
