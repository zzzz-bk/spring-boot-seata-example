package com.example.seata.account.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: Zhengyb
 * @Date: 2024/4/12 18:03
 **/
@Data
public class OrderDto implements Serializable {
    private String orderNo;
    private String userId;
    private String productCode;
    private Integer orderCount;
    private BigDecimal orderAmount;
}
