package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Invoice;
import com.kodilla.ecommercee.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
    List<Invoice> findByUser(User user);
}
