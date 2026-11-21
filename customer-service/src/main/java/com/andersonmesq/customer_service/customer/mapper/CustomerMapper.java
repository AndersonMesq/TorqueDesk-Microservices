package com.andersonmesq.customer_service.customer.mapper;

import com.andersonmesq.TorqueDesk.customer.dto.CustomerResponse;
import com.andersonmesq.TorqueDesk.customer.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponse toResponse(Customer customer);
}