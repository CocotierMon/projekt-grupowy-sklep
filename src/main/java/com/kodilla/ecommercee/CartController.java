package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.exceptions.CartNotFoundException;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.CartDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    private CartDbService cartDbService;
    private CartMapper cartMapper;
    ProductMapper productMapper;
    OrderMapper orderMapper;


    @Autowired
    public CartController(CartDbService cartDbService, CartMapper cartMapper) {
        this.cartDbService = cartDbService;
        this.cartMapper = cartMapper;
    }

    @RequestMapping(method = RequestMethod.POST, value = "createCart")
    public void createCart(@RequestBody CartDto cartDto) {
        cartDbService.saveCart(cartMapper.mapToCart(cartDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCartById")
    public CartDto getCart(@RequestParam Long id) throws CartNotFoundException {
        return cartMapper.mapToCartDto(cartDbService.getCart(id).orElseThrow(CartNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateCart")
    public CartDto updateCart(@RequestBody CartDto cartDto) {
        return cartMapper.mapToCartDto(cartDbService.saveCart(cartMapper.mapToCart(cartDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteCart")
    public void deleteCart(@RequestParam Long id) {
        cartDbService.deleteCart(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getValue")
    public BigDecimal getValue(@RequestParam Long id) {
        return cartDbService.getCart(id).get().getSum();
    }

    @RequestMapping(method = RequestMethod.POST, value = "addProduct")
    public void addProduct(@RequestParam int amount, @RequestBody ProductDto productDto, @RequestParam Long id) {
        Cart cart = cartDbService.getCart(id).get();
        cartDbService.getCart(id).get().addProduct(productMapper.mapToProduct(productDto), amount);
        cartDbService.saveCart(cart);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<Product> getProducts(@RequestParam Long id) {
        return cartDbService.getCart(id).get().getProducts();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void deleteProduct(@RequestParam Long id, @RequestBody ProductDto productDto) {
        cartDbService.getCart(id).get().getProducts().remove(productMapper.mapToProduct(productDto));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addOrder")
    public void addOrder(@RequestParam Long id, @RequestBody OrderDto orderDto) {
        cartDbService.getCart(id).get().getOrders().add(orderMapper.mapToOrder(orderDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getOrders")
    public List<Order> getOrders(@RequestParam Long id) {
        return cartDbService.getCart(id).get().getOrders();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrder")
    public void deleteOrder(@RequestParam Long id, @RequestBody OrderDto orderDto) {
        cartDbService.getCart(id).get().getOrders().remove(orderMapper.mapToOrder(orderDto));
    }
}
