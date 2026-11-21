package com.andersonmesq.customer_service.customer.dto;

import java.util.UUID;

public record CustomerResponse (
        UUID id,
        String name,
        String email
){
}