package com.jfjara.beautyapp.beautyApp.infrastructure.spring.config;

import com.jfjara.beautyapp.beautyApp.application.usecase.customer.*;
import com.jfjara.beautyapp.beautyApp.application.usecase.invoice.*;
import com.jfjara.beautyapp.beautyApp.application.usecase.service.*;
import com.jfjara.beautyapp.beautyApp.domain.model.config.DatabaseBeanNameConstant;
import com.jfjara.beautyapp.beautyApp.domain.port.repository.CustomerRepository;
import com.jfjara.beautyapp.beautyApp.domain.port.repository.InvoiceRepository;
import com.jfjara.beautyapp.beautyApp.domain.port.repository.QRRepository;
import com.jfjara.beautyapp.beautyApp.domain.port.repository.ServiceRepository;
import com.jfjara.beautyapp.beautyApp.domain.port.usecase.customer.*;
import com.jfjara.beautyapp.beautyApp.domain.port.usecase.invoice.*;
import com.jfjara.beautyapp.beautyApp.domain.port.usecase.service.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public FindCustomerById findCustomerById(
            @Qualifier(DatabaseBeanNameConstant.DATABASE_CUSTOMER_REPOSITORY) final CustomerRepository customerRepository) {
        return new FindCustomerByIdUseCase(customerRepository);
    }

    @Bean
    public FindAllCustomers findAllCustomers(
            @Qualifier(DatabaseBeanNameConstant.DATABASE_CUSTOMER_REPOSITORY) final CustomerRepository customerRepository) {
        return new FindAllCustomersUseCase(customerRepository);
    }

    @Bean
    public GenerateCustomerQR generateCustomerQR(final QRRepository qrRepository) {
        return new GenerateCustomerQRUseCase(qrRepository);
    }

    @Bean
    public AddCustomer addCustomer(
            @Qualifier(DatabaseBeanNameConstant.DATABASE_CUSTOMER_REPOSITORY) final CustomerRepository customerRepository) {
        return new AddCustomerUseCase(customerRepository);
    }

    @Bean
    public UpdateCustomer updateCustomer(
            @Qualifier(DatabaseBeanNameConstant.DATABASE_CUSTOMER_REPOSITORY) final CustomerRepository customerRepository) {
        return new UpdateCustomerUseCase(customerRepository);
    }

    @Bean
    public FindServiceById findServiceById(final ServiceRepository serviceRepository) {
        return new FindServiceByIdUseCase(serviceRepository);
    }

    @Bean
    public FindAllServices findAllServices(final ServiceRepository serviceRepository) {
        return new FindAllServicesUseCase(serviceRepository);
    }

    @Bean
    public AddService addService(final ServiceRepository serviceRepository) {
        return new AddServiceUseCase(serviceRepository);
    }

    @Bean
    public DeleteService deleteService(final ServiceRepository serviceRepository) {
        return new DeleteServiceUseCase(serviceRepository);
    }

    @Bean
    public UpdateService updateService(final ServiceRepository serviceRepository) {
        return new UpdateServiceUseCase(serviceRepository);
    }

    @Bean
    public FindInvoiceById findInvoiceById(final InvoiceRepository invoiceRepository) {
        return new FindInvoiceByIdUseCase(invoiceRepository);
    }

    @Bean
    public FindInvoicesByDateRange findInvoicesByDateRange(final InvoiceRepository invoiceRepository) {
        return new FindInvoicesByDateRangeUseCase(invoiceRepository);
    }

    @Bean
    public AddInvoice addInvoice(final InvoiceRepository invoiceRepository) {
        return new AddInvoiceUseCase(invoiceRepository);
    }

    @Bean
    public UpdateInvoice updateInvoice(final InvoiceRepository invoiceRepository) {
        return new UpdateInvoiceUseCase(invoiceRepository);
    }

    @Bean
    public DeleteInvoice deleteInvoice(final InvoiceRepository invoiceRepository) {
        return new DeleteInvoiceUseCase(invoiceRepository);
    }
}
