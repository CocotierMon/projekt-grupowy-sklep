package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {
    private ProductMapper productMapper;

    @Autowired
    public OrderMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public Order mapToOrder(final OrderDto orderDto) {
        return new Order(orderDto.getId(),
                orderDto.getDate_of_order(),
                orderDto.getDate_of_order_acceptance(),
                orderDto.getFulfillment(),
                orderDto.getCart(),
                orderDto.getDelivery(),
                orderDto.getInvoice(),
                productMapper.mapToProductList(orderDto.getProducts()),
                orderDto.getSum(),
                orderDto.getTotal_sum_of_order(),
                orderDto.getUser());
    }

    public OrderDto mapToOrderDto(final Order order) {
        return new OrderDto(order.getId(),
                order.getDate_of_order(),
                order.getDate_of_order_acceptance(),
                order.getFulfillment(),
                order.getCart(),
                order.getDelivery(),
                order.getInvoice(),
                productMapper.mapToProductDtoList(order.getProducts()),
                order.getSum(),
                order.getTotal_sum_of_order(),
                order.getUser());
    }

    public List<OrderDto> mapToOrderDtoList(List<Order> orderList) {
        return orderList.stream()
                .map(o -> new OrderDto(o.getId(),
                        o.getDate_of_order(),
                        o.getDate_of_order_acceptance(),
                        o.getFulfillment(),
                        o.getCart(),
                        o.getDelivery(),
                        o.getInvoice(),
                        productMapper.mapToProductDtoList(o.getProducts()),
                        o.getSum(),
                        o.getTotal_sum_of_order(),
                        o.getUser()))
                .collect(Collectors.toList());
    }

    public List<Order> mapToOrderList(List<OrderDto> orderList) {
        return orderList.stream()
                .map(o -> new Order(o.getId(),
                        o.getDate_of_order(),
                        o.getDate_of_order_acceptance(),
                        o.getFulfillment(),
                        o.getCart(),
                        o.getDelivery(),
                        o.getInvoice(),
                        productMapper.mapToProductList(o.getProducts()),
                        o.getSum(),
                        o.getTotal_sum_of_order(),
                        o.getUser()))
                .collect(Collectors.toList());
    }
}