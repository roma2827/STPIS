package com.stpis.backend.service.impl;

import com.stpis.backend.entity.BO.UserBO;
import com.stpis.backend.entity.UserEntity;
import com.stpis.backend.repository.UserRepo;
import com.stpis.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserEntity create(UserBO userBO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setLogin(userBO.getLogin()); userEntity.setPassword(userBO.getPassword());
        userEntity.setMoney(BigDecimal.ZERO); userEntity.setRole("USER");
        return userRepo.save(userEntity);
    }

    @Override
    public UserEntity getByLogin(String login) {
        return userRepo.findByLogin(login);
    }
}
