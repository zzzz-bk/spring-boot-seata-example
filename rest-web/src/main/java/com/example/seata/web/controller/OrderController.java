package com.example.seata.web.controller;

import com.example.seata.account.common.dto.OrderRequest;
import com.example.seata.account.common.response.ObjectResponse;
import com.example.seata.web.service.IRestOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Zhengyb
 * @Date: 2024/4/13 23:30
 **/
@RestController
public class OrderController {
    @Autowired
    private IRestOrderService restOrderService;

    @PostMapping("/order")
    ObjectResponse order(@RequestBody OrderRequest request) throws Exception {
        return restOrderService.handleBusiness(request);
    }
}
