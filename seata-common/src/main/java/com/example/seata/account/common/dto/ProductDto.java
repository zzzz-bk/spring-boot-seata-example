package com.example.seata.account.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Zhengyb
 * @Date: 2024/4/12 18:06
 **/
@Data
public class ProductDto implements Serializable {
    private Integer id;
    private String productCode;
    private String name;
    private Integer count;
}
