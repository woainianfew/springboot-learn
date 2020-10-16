/**
 * Copyright (C) 2017 The BEST Authors
 */
package com.huyang.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户DO
 *
 * @author huyang
 * @since 1.0
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -6056125703075132981L;

    private Integer id;

    private String account;

    private String password;

    private String username;
}
    