package com.stpis.backend.service.impl;

import com.stpis.backend.entity.ServiceEntity;
import com.stpis.backend.entity.SubscriptionsEntity;
import com.stpis.backend.entity.UserEntity;
import com.stpis.backend.repository.ServiceRepo;
import com.stpis.backend.repository.SubscriptionRepo;
import com.stpis.backend.repository.UserRepo;
import com.stpis.backend.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionRepo subscriptionRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ServiceRepo serviceRepo;

    @Override
    public void subscribe(SubscriptionsEntity subscriptionsEntity) {
        subscriptionRepo.save(subscriptionsEntity);
    }

    @Override
    public void pay() {
        List<SubscriptionsEntity> entityList = (List<SubscriptionsEntity>) subscriptionRepo.findAll();
        for (SubscriptionsEntity entity : entityList) {
            UserEntity user = userRepo.findById(entity.getUserId()).get();
            ServiceEntity service = serviceRepo.findById(entity.getServiceId()).get();
            BigDecimal money = user.getMoney().subtract(service.getCoast());
            if (money.compareTo(BigDecimal.ZERO) < 0) {
                subscriptionRepo.delete(entity);
            } else {
                user.setMoney(money);
                userRepo.save(user);
            }
        }
    }
}
