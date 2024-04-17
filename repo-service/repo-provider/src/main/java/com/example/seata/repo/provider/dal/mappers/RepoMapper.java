package com.example.seata.repo.provider.dal.mappers;

import org.apache.ibatis.annotations.Param;

/**
 * @author anisa
 */
public interface RepoMapper {

    /**
     * 减少库存
     * @param productCode 产品编号
     * @param count 数量
     * @return 影响行数
     */
    int decreaseRepo(@Param("productCode") String productCode,@Param("count") Integer count);
}
