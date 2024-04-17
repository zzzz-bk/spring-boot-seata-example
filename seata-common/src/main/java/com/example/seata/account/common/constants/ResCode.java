package com.example.seata.account.common.constants;

/**
 * @author anisa
 */

public enum ResCode {
    /**成功**/
    SUCCESS(200,"成功"),
    /**系统异常**/
    SYSTEM_EXCEPTION(500,"系统异常"),
    /**系统错误**/
    FAILED(999,"系统错误");
    private int code;
    private String message;
    ResCode(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
