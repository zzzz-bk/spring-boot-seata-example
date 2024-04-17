package com.example.seata.repo.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: Zhengyb
 * @Date: 2024/4/13 16:18
 **/
@SpringBootApplication
@MapperScan(basePackages = {"com.example.seata.repo.provider.dal.mappers"})
public class ProviderMain {
    public static void main(String[] args){
        SpringApplication.run(ProviderMain.class,args);
    }
}
