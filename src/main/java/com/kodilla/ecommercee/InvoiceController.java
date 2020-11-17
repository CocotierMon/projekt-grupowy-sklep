package com.kodilla.ecommercee;

import com.kodilla.ecommercee.dto.InvoiceDto;
import com.kodilla.ecommercee.mapper.InvoiceMapper;
import com.kodilla.ecommercee.service.InvoiceDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/invoice")
public class InvoiceController {

    private InvoiceDbService invoiceDbService;
    private InvoiceMapper invoiceMapper;

    @Autowired
    public InvoiceController(InvoiceDbService invoiceDbService, InvoiceMapper invoiceMapper) {
        this.invoiceDbService = invoiceDbService;
        this.invoiceMapper = invoiceMapper;
    }

    @RequestMapping(method = RequestMethod.POST, value = "createInvoice")
    public void createInvoice(@RequestBody InvoiceDto invoiceDto) {
        invoiceDbService.saveInvoice(invoiceMapper.mapToInvoice(invoiceDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getInvoice")
    public InvoiceDto getInvoiceById(@RequestParam Long id) {
        return invoiceMapper.mapToInvoiceDto(invoiceDbService.getInvoice(id).get());
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateInvoice")
    public InvoiceDto updateInvoice(@RequestBody InvoiceDto invoiceDto) {
        return invoiceMapper.mapToInvoiceDto(invoiceDbService.saveInvoice(invoiceMapper.mapToInvoice(invoiceDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteInvoice")
    public void deleteInvoice(@RequestParam Long id) {
        invoiceDbService.deleteInvoice(id);
    }

}
