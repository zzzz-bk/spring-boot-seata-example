package com.example.seata.web.service;

import com.example.seata.account.common.dto.OrderRequest;
import com.example.seata.account.common.response.ObjectResponse;

/**
 * @author anisa
 */
public interface IRestOrderService {
    /**
     * 处理订单请求
     * @param request 请求
     * @return 结果
     * @throws Exception
     */
    ObjectResponse handleBusiness(OrderRequest request) throws Exception;
}
