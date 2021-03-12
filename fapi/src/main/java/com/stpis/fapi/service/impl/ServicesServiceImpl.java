package com.stpis.fapi.service.impl;

import com.stpis.fapi.service.ServicesService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ServicesServiceImpl implements ServicesService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<com.stpis.fapi.models.Service> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        com.stpis.fapi.models.Service[] servicesResponse = restTemplate.getForObject(backendServerUrl + "/api/service", com.stpis.fapi.models.Service[].class);
        return servicesResponse == null ? Collections.emptyList() : Arrays.asList(servicesResponse);
    }

    @Override
    public void create(com.stpis.fapi.models.Service service) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(backendServerUrl + "/api/service", service, com.stpis.fapi.models.Service.class);
    }

    @Override
    public void delete(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/service/" + id);
    }
}
