package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {
    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAllOrders(){ return orderRepository.findAll(); }

    public Optional<Order> getOrder(final Long id){
        return orderRepository.findById(id);
    }

    public void saveOrder(final Order order) { orderRepository.save(order); }

    public void deleteOrder(final Long id){ orderRepository.deleteById(id); }
}
