package com.jfjara.beautyapp.beautyApp.infrastructure.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String firstSurname;
    private String lastSurname;
    private Long internalId;
    private String phone;
    private String mail;
    @OneToMany(mappedBy = "customer")
    private List<ScheduledDateEntity> dates;

    public CustomerEntity updateFields(final CustomerEntity customerEntity) {
        this.setName(customerEntity.getName());
        this.setFirstSurname(customerEntity.getFirstSurname());
        this.setLastSurname(customerEntity.getLastSurname());
        this.setPhone(customerEntity.getPhone());
        this.setMail(customerEntity.getMail());
        return this;
    }

}
