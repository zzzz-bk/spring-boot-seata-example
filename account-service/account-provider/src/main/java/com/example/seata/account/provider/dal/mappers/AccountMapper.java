package com.example.seata.account.provider.dal.mappers;

import com.example.seata.account.common.response.ObjectResponse;
import org.apache.ibatis.annotations.Param;

/**
 * @author anisa
 */
public interface AccountMapper {
    /**
     * 减少余额
     * @param userId 用户id
     * @param balance 余额
     * @return 影响行数
     */
    int decreaseAccount(@Param("userId") String userId,@Param("balance") Double balance);
}
