/**
 * Copyright (C) 2017 The BEST Authors
 */
package com.huyang.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色DO
 *
 * @author huyang
 * @since 1.0
 */
@Data
public class Role implements Serializable {

    private static final Long serialVersionUID = -1767327914553823741L;

    private Integer id;

    private String role;

    private String desc;
}
    