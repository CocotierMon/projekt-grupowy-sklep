package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Invoice;
import com.kodilla.ecommercee.dto.InvoiceDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InvoiceMapper {

    public Invoice mapToInvoice(InvoiceDto invoiceDto) {
        return new Invoice(invoiceDto.getId(),
                invoiceDto.getUser(),
                invoiceDto.getOrder());
    }

    public InvoiceDto mapToInvoiceDto(Invoice invoice) {
        return new InvoiceDto(invoice.getId(),
                invoice.getUser(),
                invoice.getOrder());
    }

    public List<Invoice> mapToInvoiceList(List<InvoiceDto> invoices) {
        return invoices.stream()
                .map(i -> new Invoice(i.getId(),
                        i.getUser(),
                        i.getOrder()))
                .collect(Collectors.toList());
    }

    public List<InvoiceDto> mapToInvoiceDtoList(List<Invoice> invoices) {
        return invoices.stream()
                .map(i -> new InvoiceDto(i.getId(),
                        i.getUser(),
                        i.getOrder()))
                .collect(Collectors.toList());
    }

}
