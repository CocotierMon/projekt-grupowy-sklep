package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Delivery;
import com.kodilla.ecommercee.dto.DeliveryDto;
import org.springframework.stereotype.Component;

@Component
public class DeliveryMapper {

    public Delivery mapToDelivery(DeliveryDto deliveryDto) {
        return new Delivery(deliveryDto.getId(),
                deliveryDto.getValue(),
                deliveryDto.getOrder());
    }

    public DeliveryDto mapToDeliveryDto(Delivery delivery) {
        return new DeliveryDto(delivery.getId(),
                delivery.getValue(),
                delivery.getOrder());
    }
}
