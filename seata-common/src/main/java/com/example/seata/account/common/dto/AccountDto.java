package com.example.seata.account.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: Zhengyb
 * @Date: 2024/4/12 18:01
 **/
@Data
public class AccountDto implements Serializable {
    private Integer id;
    private String userId;
    private BigDecimal balance;
}
