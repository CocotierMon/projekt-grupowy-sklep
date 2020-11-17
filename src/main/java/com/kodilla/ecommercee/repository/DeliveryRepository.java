package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Delivery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface DeliveryRepository extends CrudRepository<Delivery, Long> {

    @Override
    Optional<Delivery> findById(Long id);

    @Override
    boolean existsById(Long id);

    @Override
    List<Delivery> findAll();

    @Override
    Delivery save(Delivery delivery);

    @Override
    void deleteById(Long id);

    @Override
    void delete(Delivery delivery);

    @Override
    void deleteAll();
}
