package com.stpis.fapi.models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class User {
    private Long userId;
    private String role;
    private String login;
    private String password;
    private BigDecimal money;
}
