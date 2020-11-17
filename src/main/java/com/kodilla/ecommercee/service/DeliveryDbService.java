package com.kodilla.ecommercee.service;


import com.kodilla.ecommercee.domain.Delivery;
import com.kodilla.ecommercee.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryDbService {

    private DeliveryRepository deliveryRepository;
    @Autowired
    public DeliveryDbService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public List<Delivery> getAllDelivery() {
        return deliveryRepository.findAll();
    }

    public Optional<Delivery> getDelivery(final Long id) {
        return deliveryRepository.findById(id);
    }

    public Delivery saveDelivery(final Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    public void deleteDelivery(final Long id) {
        deliveryRepository.deleteById(id);
    }
}