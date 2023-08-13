package com.jfjara.beautyapp.beautyApp.infrastructure.mysql.client;

import com.jfjara.beautyapp.beautyApp.infrastructure.mysql.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerMySQLClient extends JpaRepository<CustomerEntity, Long> {

    Optional<CustomerEntity> findByInternalId(final Long id);
}
