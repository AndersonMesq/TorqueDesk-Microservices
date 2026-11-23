package com.andersonmesq.service_order_service.service_order.dto;

import java.util.UUID;

public record ServiceOrderResponse(
        UUID serviceId,
        UUID vehicleId,
        String customerName,
        String vehicleName,
        String serviceName
) {
}
