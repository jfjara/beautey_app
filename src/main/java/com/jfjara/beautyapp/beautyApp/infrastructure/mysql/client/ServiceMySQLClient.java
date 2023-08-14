package com.jfjara.beautyapp.beautyApp.infrastructure.mysql.client;

import com.jfjara.beautyapp.beautyApp.infrastructure.mysql.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceMySQLClient extends JpaRepository<ServiceEntity, Long> {
}
