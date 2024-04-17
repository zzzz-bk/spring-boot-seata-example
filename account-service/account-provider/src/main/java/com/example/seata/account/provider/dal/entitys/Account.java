package com.example.seata.account.provider.dal.entitys;

import lombok.Data;

/**
 * @Author: Zhengyb
 * @Date: 2024/4/12 21:19
 **/
@Data
public class Account {
    private Integer id;
    private String userId;
    private Double balance;
}
