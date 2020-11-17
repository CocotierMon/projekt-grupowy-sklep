package com.kodilla.ecommercee;

import com.kodilla.ecommercee.dto.DeliveryDto;
import com.kodilla.ecommercee.mapper.DeliveryMapper;
import com.kodilla.ecommercee.service.DeliveryDbService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/delivery")
public class DeliveryController {

    private DeliveryDbService deliveryDbService;
    private DeliveryMapper deliveryMapper;

    @RequestMapping(method = RequestMethod.POST, value = "createDelivery")
    public void createDelivery(@RequestBody DeliveryDto deliveryDto) {
        deliveryDbService.saveDelivery(deliveryMapper.mapToDelivery(deliveryDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getDeliveryById")
    public DeliveryDto getDelivery(@RequestParam Long id) {
        return deliveryMapper.mapToDeliveryDto(deliveryDbService.getDelivery(id).get());
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateDelivery")
    public DeliveryDto updateDelivery(@RequestBody DeliveryDto deliveryDto) {
        return deliveryMapper.mapToDeliveryDto(deliveryDbService.saveDelivery(deliveryMapper.mapToDelivery(deliveryDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteDelivery")
    public void deleteDelivery(@RequestParam Long id) {
        deliveryDbService.deleteDelivery(id);
    }

}