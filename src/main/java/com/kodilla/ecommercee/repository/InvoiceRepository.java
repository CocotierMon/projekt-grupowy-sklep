package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Invoice;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

    @Override
    Invoice save(Invoice invoice);

    @Override
    Optional<Invoice> findById(Long id);

    @Override
    boolean existsById(Long id);

    @Override
    Iterable<Invoice> findAll();

    @Override
    Iterable<Invoice> findAllById(Iterable<Long> ids);

    @Override
    long count();

    @Override
    void deleteById(Long id);

    @Override
    void deleteAll();

}
