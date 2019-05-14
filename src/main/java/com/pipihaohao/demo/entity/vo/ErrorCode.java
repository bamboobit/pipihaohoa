package com.pipihaohao.demo.entity.vo;

/**
 * @Auther: xfh
 * @Date: 2019/5/10
 * @Description:
 */
public enum ErrorCode {
    SUCCESS(0,"处理成功"),
    SERVER_ERROR(-10001,"服务器内部错误"),
    SERVER_BUSY(-10002,"服务器繁忙"),
    SERVER_TIOMEOUT(-10003,"服务器超时"),
    ERROR_EMAIL(-20101,"密码不合法"),
    ERROR_PASSWOR(-20102,"邮箱不合法"),
    REGIETERED_EMAIL(-20111,"邮箱已注册"),
    ERROR_PARAMS(-11111,"参数错误"),
    TOKEN_EXPIRE(-1,"token过期"),
    TOKEN_INVALID(-2,"token不合法"),
    AUTH_INVALID(-3,"用户不合法"),

    ;
    private Integer code;
    private String msg;
    public Integer getCode(){ return code;}
    public String getMsg(){return msg;}
    ErrorCode(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
