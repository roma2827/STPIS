package com.stpis.backend.service.impl;

import com.stpis.backend.entity.ServiceEntity;
import com.stpis.backend.repository.ServiceRepo;
import com.stpis.backend.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicesServiceImpl implements ServicesService {

    @Autowired
    private ServiceRepo serviceRepo;

    @Override
    public List<ServiceEntity> getAll() {
        return (List<ServiceEntity>) serviceRepo.findAll();
    }

    @Override
    public void create(ServiceEntity serviceEntity) {
        serviceRepo.save(serviceEntity);
    }

    @Override
    public void delete(Long id) {
        serviceRepo.deleteById(id);
    }
}
