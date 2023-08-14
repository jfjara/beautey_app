package com.jfjara.beautyapp.beautyApp.infrastructure.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "services")
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    @Column(name = "duration")
    private Integer durationInMinutes;
    private boolean active;

    @ManyToMany(mappedBy = "services")
    private List<ScheduledDateEntity> scheduledDates;

    public ServiceEntity update(final ServiceEntity service) {
        this.setDescription(service.getDescription());
        this.setPrice(service.getPrice());
        this.setName(service.getName());
        this.setActive(service.isActive());
        this.setDurationInMinutes(service.getDurationInMinutes());
        return this;
    }
}
