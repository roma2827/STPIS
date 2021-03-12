package com.stpis.backend.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "service")
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long serviceId;

    @Column
    @NotNull
    @Size(max = 30)
    private String name;

    @Basic
    @Column
    @NotNull
    @Size(max = 100)
    private String description;

    @Basic
    @Column
    @NotNull
    private BigDecimal coast;
}
