package com.stpis.fapi.service;

import com.stpis.fapi.models.Service;

import java.util.List;

public interface ServicesService {
    List<Service> getAll();
    void create(Service service);
    void delete(Long id);
}
