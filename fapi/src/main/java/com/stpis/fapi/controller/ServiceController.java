package com.stpis.fapi.controller;

import com.stpis.fapi.models.Service;
import com.stpis.fapi.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service")
public class ServiceController {

    @Autowired
    private ServicesService servicesService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Service>> getAll(){
        return ResponseEntity.ok(servicesService.getAll());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody Service service){
        servicesService.create(service);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/{serviceId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(name = "serviceId") Long serviceId){
        servicesService.delete(serviceId);
    }
}
