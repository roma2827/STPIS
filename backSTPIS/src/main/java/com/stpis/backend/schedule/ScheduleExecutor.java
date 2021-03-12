package com.stpis.backend.schedule;

import com.stpis.backend.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleExecutor {

    @Autowired
    private SubscriptionService subscriptionService;

    @Scheduled(cron = "0 * * ? * *")
    public void runAutoSubscribePay() {
        subscriptionService.pay();
    }
}
