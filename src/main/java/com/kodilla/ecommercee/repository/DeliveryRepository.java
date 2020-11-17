package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Delivery;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface DeliveryRepository extends CrudRepository<Delivery,Long> {
    @Override
    Delivery save(Delivery delivery);

    @Override
    Optional<Delivery> findById(Long id);

    @Override

    boolean existsById(Long id);

    @Override
    Iterable<Delivery> findAll();


    @Override
    long count();


    @Override
    void deleteById(Long id);

    @Override
    void delete(Delivery delivery);

    @Override
    void deleteAll();

}
