package com.stpis.backend.service;

import com.stpis.backend.entity.SubscriptionsEntity;

public interface SubscriptionService {
    void subscribe(SubscriptionsEntity subscriptionsEntity);
    void pay();
}
