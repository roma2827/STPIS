package com.stpis.backend.entity.BO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserBO {
    private String login;
    private String password;

    public UserBO() {
    }
}
