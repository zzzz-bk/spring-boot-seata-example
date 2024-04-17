package com.example.seata.repo.provider.impl;

import com.example.seata.account.common.constants.ResCode;
import com.example.seata.account.common.dto.ProductDto;
import com.example.seata.account.common.response.ObjectResponse;
import com.example.seata.repo.api.inf.IRepoService;
import com.example.seata.repo.provider.dal.mappers.RepoMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: Zhengyb
 * @Date: 2024/4/13 16:39
 **/
@Service
@Slf4j
public class RepoService implements IRepoService {
    @Autowired
    private RepoMapper repoMapper;

    @Override
    public ObjectResponse decreaseRepo(ProductDto productDto) {
        ObjectResponse response = new ObjectResponse();
        try{
            int reslut = repoMapper.decreaseRepo(productDto.getProductCode(),productDto.getCount());
            if(reslut>0){
                response.setCode(ResCode.SUCCESS.getCode());
                response.setMsg(ResCode.SUCCESS.getMessage());
                return response;
            }
            response.setMsg(ResCode.FAILED.getMessage());
            response.setCode(ResCode.FAILED.getCode());
        }catch (Exception e){
            response.setCode(ResCode.SYSTEM_EXCEPTION.getCode());
            response.setMsg(ResCode.SYSTEM_EXCEPTION.getMessage());
            log.error("decrease repo occur error:",e);
        }
        return response;
    }
}
