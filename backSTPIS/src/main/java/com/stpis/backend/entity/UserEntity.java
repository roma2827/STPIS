package com.stpis.backend.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column
    @NotNull
    @Size(max = 10)
    private String role;

    @Basic
    @Column
    @NotNull
    @Size(max = 20)
    private String login;

    @Basic
    @Column
    @NotNull
    @Size(max = 100)
    private String password;

    @Basic
    @Column
    @NotNull
    private BigDecimal money;
}
