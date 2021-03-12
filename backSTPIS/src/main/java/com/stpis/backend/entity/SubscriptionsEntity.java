package com.stpis.backend.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "subscriptions")
public class SubscriptionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscriptions_id")
    private Long subscriptionsId;

    @Column
    @NotNull
    private Long userId;

    @Column
    @NotNull
    private Long serviceId;
}
