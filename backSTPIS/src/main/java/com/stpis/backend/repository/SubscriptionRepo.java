package com.stpis.backend.repository;

import com.stpis.backend.entity.SubscriptionsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepo extends CrudRepository<SubscriptionsEntity, Long> {
}
