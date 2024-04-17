package com.example.seata.account.common.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Zhengyb
 * @Date: 2024/4/12 19:33
 **/
@Data
public class AbstractResponse implements Serializable {
    private int code;
    private String msg;
}
