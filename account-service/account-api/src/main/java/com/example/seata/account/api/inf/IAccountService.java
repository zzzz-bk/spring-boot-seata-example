package com.example.seata.account.api.inf;

import com.example.seata.account.common.dto.AccountDto;
import com.example.seata.account.common.response.ObjectResponse;

public interface IAccountService {
    ObjectResponse decreaseAccount(AccountDto accountDto);
}
