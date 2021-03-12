package com.stpis.fapi.service.impl;

import com.stpis.fapi.models.Subscriptions;
import com.stpis.fapi.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public void subscribe(Subscriptions subscriptions) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(backendServerUrl + "/api/subscription", subscriptions, Subscriptions.class);
    }
}
