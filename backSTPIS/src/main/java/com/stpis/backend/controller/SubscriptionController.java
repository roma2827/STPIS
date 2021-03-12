package com.stpis.backend.controller;

import com.stpis.backend.entity.SubscriptionsEntity;
import com.stpis.backend.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @RequestMapping(method = RequestMethod.POST)
    public void subscribe(@RequestBody SubscriptionsEntity subscriptionsEntity){
        subscriptionService.subscribe(subscriptionsEntity);
    }
}
