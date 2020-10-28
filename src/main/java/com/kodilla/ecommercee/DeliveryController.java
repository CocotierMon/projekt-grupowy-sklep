package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/delivery")
public class DeliveryController {

    @RequestMapping(method = RequestMethod.POST , value = "createDelivery")
    public void createDelivery(){
    }

    @RequestMapping(method = RequestMethod.GET, value = "getDelivery")
    public String getDelivery() {
        return "Delivery";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateDelivery")
    public String updateDelivery(String someDelivery) {
        return "Updated Delivery";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteDelivery")
    public void deleteDelivery(Long DeliveryID){
    }

}
