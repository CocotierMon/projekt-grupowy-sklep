package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartTestSuite {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void testCartRepositorySave() {

        //Given
        Cart cart = new Cart();

        //When
        cartRepository.save(cart);

        //Then
        long id = cart.getId();
        Optional<Cart> readCart = cartRepository.findById(id);
        Assert.assertTrue(readCart.isPresent());

        //CleanUp
        try {
            cartRepository.deleteById(id);
        } catch (Exception e) {
        }
    }

    @Test
    public void testRelationWithUser() {
        //Given
        Cart cart = new Cart();
        User user = new User();

        cartRepository.save(cart);
        user.setUsername("Username");
        user.setUserKey(12345L);
        user.setCart(cart);
        cart.setUser(user);


        //When
        long id = user.getCart().getId();
        long id1 = cart.getId();

        //Then
        Assert.assertTrue(id == id1);
        Assert.assertNotEquals(0, id);

        //CleanUp
        try {
            cartRepository.deleteById(id);
            cartRepository.deleteById(id1);

        } catch (Exception e) {
        }
    }

    @Test
    public void testRelationWithProduct() {
        //Given
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();

        Product product1 = new Product("kurtka zimowa", "Pellentesque tempus", new BigDecimal(100), 1);
        Product product2 = new Product("płaszcz", "Pellentesque tempus", new BigDecimal(150), 1);
        cart1.setId((long) 1);
        cart2.setId((long) 2);
        cartRepository.save(cart1);
        cartRepository.save(cart2);

        cart1.getProducts().add(product1);
        cart1.getProducts().add(product2);
        cart2.getProducts().add(product2);

        product1.setCart(cart1);
        product2.setCart(cart1);
        product2.setCart(cart2);

        //When
        long id1 = cart1.getId();
        long id2 = cart2.getId();

        //Then
        Assert.assertNotEquals(2, id1);
        Assert.assertNotEquals(1, id2);

        //CleanUp
        try {
            cartRepository.deleteById(id1);
            cartRepository.deleteById(id2);
            productRepository.deleteAll();
        } catch (Exception e) {
        }
    }

    @Test
    public void testRelationWithOrder() {
        //Given
        Cart cart1 = new Cart();
        Order order1 = new Order();

        cartRepository.save(cart1);
        orderRepository.save(order1);
        cart1.setId((long) 1);
        order1.setId((long) 10);
        cart1.getOrders().add(order1);
        order1.setCart(cart1);

        //When
        long id1 = cart1.getId();
        long orId = order1.getId();

        //Then
        Assert.assertEquals(1, id1);
        Assert.assertEquals(10, orId);
        try {
            cartRepository.deleteById(id1);
            orderRepository.deleteById(orId);
        } catch (Exception e) {
        }
    }
}









