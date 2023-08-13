package com.jfjara.beautyapp.beautyApp.infrastructure.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Data
@Entity
@Table(name = "scheduled_dates")
public class ScheduledDateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startAt;

    private boolean finished;

    private String description;

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private CustomerEntity customer;

    @ManyToMany
    @JoinTable(
            name = "date_services",
            joinColumns = @JoinColumn(name = "scheduled_date_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    private List<ServiceEntity> services;
}
