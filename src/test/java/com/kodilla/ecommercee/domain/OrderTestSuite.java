package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTestSuite {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    DeliveryRepository deliveryRepository;
    @Autowired
    ProductRepository productRepository;

    @Test
    public void testOrderRepositoryCRUD() {
        //Given
        Order order = new Order();

        //When
        orderRepository.save(order);
        long idOrder = order.getId();

        //Then
        Optional<Order> readOrder = orderRepository.findById(idOrder);
        List<Order> orderList = orderRepository.findAll();
        Assert.assertTrue(readOrder.isPresent());
        Assert.assertNotEquals(0, orderList.size());

        //CleanUp
        orderRepository.deleteAll();
        Assert.assertEquals(0, orderRepository.findAll().size());
    }

    @Test
    public void testRelationWithUser() {
        //Given
        Order order = new Order();
        User userKarol = new User();
        userKarol.getOrders().add(order);
        order.setUser(userKarol);
        userRepository.save(userKarol);
        orderRepository.save(order);
        long idUser = userKarol.getId();
        long idOrder = order.getId();

        //When
        User userPiotr = userRepository.findById(idUser).get();
        userPiotr.setUsername("Piotr");
        userRepository.save(userPiotr);

        //Then
        Optional<Order> readOrder = orderRepository.findById(idOrder);
        Assert.assertEquals("Piotr", readOrder.get().getUser().getUsername());

        //CleanUp
        orderRepository.deleteAll();
        userRepository.deleteAll();
        Assert.assertEquals(0, orderRepository.findAll().size());
    }

    @Test
    public void testRelationWithDelivery() {
        //Given
        Delivery delivery = new Delivery(new BigDecimal(5));
        deliveryRepository.save(delivery);
        Order order = new Order();
        delivery.setOrder(order);
        order.setDelivery(delivery);

        //When
        orderRepository.save(order);
        long idOrder = order.getId();
        BigDecimal value = orderRepository.findById(idOrder).get().getDelivery().getValue();
        value = value.setScale(0, BigDecimal.ROUND_DOWN);

        //Then
        Assert.assertEquals(new BigDecimal(5), value);
        Assert.assertNotNull(orderRepository.findAll());

        //CleanUp
        orderRepository.deleteAll();
        deliveryRepository.deleteAll();
        Assert.assertEquals(0, orderRepository.findAll().size());
    }

    @Test
    public void testRelationWithProduct() {
        //Given
        Product product = new Product("a", "b", new BigDecimal(2), 1);
        Product product1 = new Product("c", "d", new BigDecimal(4), 1);
        Product product2 = new Product("e", "t", new BigDecimal(2), 1);
        Product product3 = new Product("r", "y", new BigDecimal(4), 1);
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();

        order1.getProducts().add(product);
        order1.getProducts().add(product1);
        order2.getProducts().add(product2);
        order2.getProducts().add(product3);
        order3.getProducts().add(product1);
        order3.getProducts().add(product2);

        product.getOrders().add(order1);
        product1.getOrders().add(order1);
        product1.getOrders().add(order3);
        product2.getOrders().add(order2);
        product2.getOrders().add(order3);
        product3.getOrders().add(order2);

        productRepository.save(product);
        long idProduct = product.getId();
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        //When
        orderRepository.save(order1);
        long idOrder = order1.getId();
        orderRepository.save(order2);
        long idOrder2 = order2.getId();
        orderRepository.save(order3);
        Product newProduct = productRepository.findById(idProduct).get();
        newProduct.setName("aaa");
        productRepository.save(newProduct);

        //Then
        List<Order> orderList = orderRepository.findAll();
        Assert.assertEquals(3, orderList.size());
        Assert.assertNotEquals(0, idOrder2);
        Assert.assertNotEquals(0, idOrder);

        //CleanUp
        orderRepository.deleteAll();
        productRepository.deleteAll();
        Assert.assertEquals(0, orderRepository.findAll().size());
    }

}
