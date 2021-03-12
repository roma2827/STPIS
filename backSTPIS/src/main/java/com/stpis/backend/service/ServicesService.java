package com.stpis.backend.service;

import com.stpis.backend.entity.ServiceEntity;

import java.util.List;

public interface ServicesService {
    List<ServiceEntity> getAll();
    void create(ServiceEntity serviceEntity);
    void delete(Long id);
}
