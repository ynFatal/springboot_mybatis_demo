package com.fatal.entity;

import lombok.Data;

@Data    // 我用 lombok 代替了下面的get/set方法
public class User {

    private Integer userId;

    private String userName;

    private String password;

    private String phone;

}