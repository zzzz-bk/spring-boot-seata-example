package com.example.seata.account.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: Zhengyb
 * @Date: 2024/4/12 21:12
 **/
@SpringBootApplication
@MapperScan(basePackages = {"com.example.seata.account.provider.dal.mappers"})
public class ProviderMain {
    public static void main(String[] args){
        SpringApplication.run(ProviderMain.class,args);
    }
}
