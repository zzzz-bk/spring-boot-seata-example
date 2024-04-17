package com.example.seata.repo.provider.dal.entitys;

import lombok.Data;

/**
 * @Author: Zhengyb
 * @Date: 2024/4/13 16:32
 **/
@Data
public class Repo {
    private Integer id;
    private String name;
    private String productCode;
    private Integer count;
}
