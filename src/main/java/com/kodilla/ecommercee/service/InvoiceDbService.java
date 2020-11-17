package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Invoice;
import com.kodilla.ecommercee.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceDbService {
    private InvoiceRepository invoiceRepository;

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Optional<Invoice> getInvoice(final Long id) {
        return invoiceRepository.findById(id);
    }

    public Invoice saveInvoice(final Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public void deleteInvoice(final Long id) {
        invoiceRepository.deleteById(id);
    }
}
