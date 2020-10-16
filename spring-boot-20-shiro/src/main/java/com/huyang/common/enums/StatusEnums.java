/**
 * Copyright (C) 2017 The BEST Authors
 */
package com.huyang.common.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * 状态枚举值
 * @author huyang
 * @since
 */
public enum StatusEnums {

    SUCCESS(200, "操作成功"),
    SYSTEM_ERROR(500,"系统错误"),
    ACCOUNT_UNKNOWN(500,"账户不存在"),
    ACCOUNT_DISABLED(13,"账号被禁用"),
    INCORRECT_CREDENTIALS(500,"用户名或密码错误"),
    PARAM_ERROR(400,"参数错误"),
    PARAM_REPEAT(400,"参数已存在"),
    PERMISSION_ERROR(403,"没有操作权限"),
    NOT_LOGININ(15,"账号未登录"),
    OYHER(-100,"其他错误");

    @Getter
    @Setter
    private int code;

    @Getter
    @Setter
    private String message;

    StatusEnums(int code, String message){
        this.code = code;
        this.message = message;
    }

}

