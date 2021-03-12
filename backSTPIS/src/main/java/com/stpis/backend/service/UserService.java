package com.stpis.backend.service;

import com.stpis.backend.entity.BO.UserBO;
import com.stpis.backend.entity.UserEntity;

public interface UserService {
    UserEntity create(UserBO userEntity);
    UserEntity getByLogin(String login);
}
