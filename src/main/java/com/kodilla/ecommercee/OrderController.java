package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/order")
public class OrderController {

    @RequestMapping(method = RequestMethod.GET, value = "getOrders")
    public List<OrderDto> getOrders() {
        return new ArrayList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getOrder")
    public OrderDto getOrder(Long orderId) {
        return new OrderDto(1L, "New order");
    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder")
    public void createOrder(OrderDto orderDto) {
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateOrder")
    public OrderDto updateOrder(Long orderId) {
        return new OrderDto(1L, "New updated order");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrder")
    public void deleteOrder(Long orderId) {
    }

}
