package com.example.seata.account.provider.impl;

import com.example.seata.account.api.inf.IAccountService;
import com.example.seata.account.common.constants.ResCode;
import com.example.seata.account.common.dto.AccountDto;
import com.example.seata.account.common.response.ObjectResponse;
import com.example.seata.account.provider.dal.mappers.AccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: Zhengyb
 * @Date: 2024/4/12 21:43
 **/
@Service
@Slf4j
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public ObjectResponse decreaseAccount(AccountDto accountDto) {
        ObjectResponse response = new ObjectResponse();
        try {
            int result = accountMapper.decreaseAccount(accountDto.getUserId(),accountDto.getBalance().doubleValue());
            if(result>0){
                response.setCode(ResCode.SUCCESS.getCode());
                response.setMsg(ResCode.SUCCESS.getMessage());
                return response;
            }
            response.setCode(ResCode.FAILED.getCode());
            response.setMsg(ResCode.FAILED.getMessage());
        } catch (Exception e) {
            log.error("decreaseAccount Occur Exception:",e);
            response.setCode(ResCode.SYSTEM_EXCEPTION.getCode());
            response.setMsg(ResCode.SYSTEM_EXCEPTION.getMessage());
        }
        return response;
    }
}
