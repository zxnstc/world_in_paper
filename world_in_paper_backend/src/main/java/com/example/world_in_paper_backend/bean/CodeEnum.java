package com.example.world_in_paper_backend.bean;

import lombok.Getter;

@Getter
public enum CodeEnum {
    //状态码按顺序依次往下写
    SUCCESS(200,"成功"),
    ERROR(400,"失败"),
    SERVER_ERROR(-1,"服务端错误"),
    SQL_ERROR(-2,"数据库错误"),
    PASSWORD_ERROR(1,"密码错误"),
    USERNAME_EXIST(2,"用户名已存在"),
    EMAIL_EXIST(3,"邮箱已被注册"),
    NEED_LOGIN(4,"用户未登录，请先登录"),
    USERNAME_OR_PASSWORD_ERROR(5,"用户名或密码错误"),
    USER_NOT_EXIST(6,"用户不存在"),
    EMAIL_NOT_EXIST(7,"邮箱不存在"),
    USER_IS_ABANDOEND(8,"用户已禁用"),
    USER_IS_DELETED(9,"用户已被删除"),
    ;
    Integer code;
    String desc;

    CodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
