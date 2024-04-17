package com.example.seata.repo.api.inf;

import com.example.seata.account.common.dto.ProductDto;
import com.example.seata.account.common.response.ObjectResponse;

/**
 * @author anisa
 */
public interface IRepoService {
    /**
     * 减少库存
     * @param productDto 商品数据对象
     * @return 操作结果
     */
    ObjectResponse decreaseRepo(ProductDto productDto);
}
