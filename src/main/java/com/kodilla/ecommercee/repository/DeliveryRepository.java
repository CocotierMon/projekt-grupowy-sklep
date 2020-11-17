package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Delivery;
import com.kodilla.ecommercee.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional

@Repository
public interface DeliveryRepository extends CrudRepository<Delivery,Long>{

    @Override
    List<Delivery> findAll();

    @Override
    Optional<Delivery> findById(Long id);

    @Override

    Delivery save(Delivery delivery);

    @Override
    void deleteById(Long id);

    @Override
    long count();

    Delivery findByOrder(Order order);
}
