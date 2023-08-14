package com.jfjara.beautyapp.beautyApp.infrastructure.mysql.config;

import com.jfjara.beautyapp.beautyApp.domain.model.config.DatabaseBeanNameConstant;
import com.jfjara.beautyapp.beautyApp.domain.port.repository.CustomerRepository;
import com.jfjara.beautyapp.beautyApp.domain.port.repository.ServiceRepository;
import com.jfjara.beautyapp.beautyApp.infrastructure.mysql.client.CustomerMySQLClient;
import com.jfjara.beautyapp.beautyApp.infrastructure.mysql.client.ServiceMySQLClient;
import com.jfjara.beautyapp.beautyApp.infrastructure.mysql.mapper.CustomerEntityMapper;
import com.jfjara.beautyapp.beautyApp.infrastructure.mysql.mapper.ServiceEntityMapper;
import com.jfjara.beautyapp.beautyApp.infrastructure.mysql.repository.CustomerMySQLRepository;
import com.jfjara.beautyapp.beautyApp.infrastructure.mysql.repository.ServiceMySQLRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySQLRepositoryConfig {

    @Bean(DatabaseBeanNameConstant.DATABASE_CUSTOMER_REPOSITORY)
    public CustomerRepository customerMySQLRepository(final CustomerMySQLClient customerMySQLClient,
                                                      final CustomerEntityMapper customerMapper) {
        return new CustomerMySQLRepository(customerMySQLClient, customerMapper);
    }

    @Bean(DatabaseBeanNameConstant.DATABASE_SERVICE_REPOSITORY)
    public ServiceRepository serviceMySQLRepository(final ServiceMySQLClient serviceMySQLClient,
                                                     final ServiceEntityMapper serviceMapper) {
        return new ServiceMySQLRepository(serviceMySQLClient, serviceMapper);
    }


}
