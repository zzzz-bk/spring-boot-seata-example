package com.example.seata.account.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: Zhengyb
 * @Date: 2024/4/12 18:07
 **/
@Data
public class OrderRequest implements Serializable {
    private String userId;
    private String productCode;
    private String name;
    private Integer count;
    private BigDecimal amount;
}
