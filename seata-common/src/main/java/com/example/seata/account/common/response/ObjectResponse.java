package com.example.seata.account.common.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Zhengyb
 * @Date: 2024/4/12 19:35
 **/
@Data
public class ObjectResponse<T> extends AbstractResponse implements Serializable {
    private T data;
}
