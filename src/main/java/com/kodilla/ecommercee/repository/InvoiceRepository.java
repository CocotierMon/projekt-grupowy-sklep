package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Invoice;
import com.kodilla.ecommercee.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Repository
@Transactional
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

    @Override
    Invoice save(Invoice invoice);

    @Override
    Optional<Invoice> findById(Long id);

    @Override
    boolean existsById(Long id);

    @Override
    List<Invoice> findAll();

    @Override
    long count();

    @Override
    void deleteById(Long id);

    @Override
    void deleteAll();
    List<Invoice> findByUser(User user);
}
