package com.stpis.fapi.models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Service {
    private Long serviceId;
    private String name;
    private String description;
    private BigDecimal coast;
}
