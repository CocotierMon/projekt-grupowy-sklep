package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Invoices;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface InvoicesRepository extends CrudRepository<Invoices, Long> {

    @Override
    Invoices save(Invoices invoice);

    @Override
    Optional<Invoices> findById(Long id);

    @Override
    boolean existsById(Long id);

    @Override
    Iterable<Invoices> findAll();

    @Override
    Iterable<Invoices> findAllById(Iterable<Long> ids);

    @Override
    long count();

    @Override
    void deleteById(Long id);

    @Override
    void deleteAll();
}
