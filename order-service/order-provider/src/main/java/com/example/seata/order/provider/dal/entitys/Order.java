package com.example.seata.order.provider.dal.entitys;

import lombok.Data;


/**
 * @Author: Zhengyb
 * @Date: 2024/4/13 10:34
 **/
@Data
public class Order {
    private Integer id;
    private String orderNo;
    private String userId;
    private String productCode;
    private Integer count;
    private Double amount;
}
