package com.kodilla.ecommercee.service;


import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartDbService {

    private CartRepository cartRepository;

    public List<Cart> getAllGroups() {
        return cartRepository.findAll();
    }

    public Optional<Cart> getCart(final Long id) {
        return cartRepository.findById(id);
    }

    public Cart saveCart(final Cart cart) {
        return cartRepository.save(cart);
    }

    public void deleteCart(final Long id) {
        cartRepository.deleteById(id);
    }
}