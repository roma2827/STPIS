package com.stpis.backend.repository;

import com.stpis.backend.entity.ServiceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepo extends CrudRepository<ServiceEntity, Long> {
}
