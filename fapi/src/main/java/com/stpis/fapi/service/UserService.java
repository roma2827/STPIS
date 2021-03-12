package com.stpis.fapi.service;


import com.stpis.fapi.models.BO.UserBO;
import com.stpis.fapi.models.User;

public interface UserService {
    User getByLogin(String login);
    User create(UserBO user);
}
