package com.stpis.backend.controller;

import com.stpis.backend.entity.ServiceEntity;
import com.stpis.backend.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service")
public class ServiceController {

    @Autowired
    private ServicesService servicesService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<ServiceEntity>> getAll(){
        return ResponseEntity.ok(servicesService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody ServiceEntity serviceEntity){
        servicesService.create(serviceEntity);
    }

    @RequestMapping(value = "/{serviceId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(name = "serviceId") Long serviceId){
        servicesService.delete(serviceId);
    }
}
