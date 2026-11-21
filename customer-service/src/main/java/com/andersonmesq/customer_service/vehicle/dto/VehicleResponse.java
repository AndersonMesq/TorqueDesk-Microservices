package com.andersonmesq.customer_service.vehicle.dto;

import java.util.UUID;

public record VehicleResponse(
        UUID id,
        String brand,
        String model,
        Integer year,
        String plate
) {
}
