package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/invoice")
public class InvoiceController {

    @RequestMapping(method = RequestMethod.POST , value = "createInvoice")
    public void createInvoice(){
    }

    @RequestMapping(method = RequestMethod.GET, value = "getInvoice")
    public String getInvoice() {
        return "Invoice";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateInvoice")
    public String updateInvoice(String someInvoice) {
        return "Updated Invoice";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteInvoice")
    public void deleteInvoice(Long InvoiceID){
    }

}
