package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.dto.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {
    private ProductMapper productMapper;
    private OrderMapper orderMapper;

    @Autowired
    public CartMapper(ProductMapper productMapper, OrderMapper orderMapper) {
        this.productMapper = productMapper;
        this.orderMapper = orderMapper;
    }

    public Cart mapToCart(CartDto cartDto) {
        return new Cart(cartDto.getId(),
                cartDto.getSum(),
                productMapper.mapToProductList(cartDto.getProductsList()),
                orderMapper.mapToOrderList(cartDto.getOrders()),
                cartDto.getUser());
    }

    public CartDto mapToCartDto(Cart cart) {
        return new CartDto(cart.getId(),
                cart.getSum(),
                productMapper.mapToProductDtoList(cart.getProducts()),
                orderMapper.mapToOrderDtoList(cart.getOrders()),
                cart.getUser());
    }
}