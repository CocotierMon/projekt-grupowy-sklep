package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.InvoiceRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserEntityTestSuite {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Test
    public void saveAndDeleteUserTest() {
        //Given
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        //When
        long countFromDb = userRepository.count();

        //Then
        Assert.assertEquals(3, countFromDb);

        //Given
        userRepository.deleteById(user1.getId());
        userRepository.deleteById(user2.getId());
        userRepository.deleteById(user3.getId());

        //When
        countFromDb = userRepository.count();

        //Then
        Assert.assertEquals(0, countFromDb);
    }

    @Test
    public void findUserTest() {
        //Given
        User user1 = new User();
        User user2 = new User();

        userRepository.save(user1);
        userRepository.save(user2);

        Long id1 = user1.getId();
        Long id2 = user2.getId();
        String username1 = user1.getUsername();

        //When
        List<User> result = userRepository.findAll();
        Optional<User> user1fromDb = userRepository.findById(id1);
        Optional<User> user2fromDb = userRepository.findById(id2);
        List<User> resultFindByUsername = userRepository.findByUsername(username1);

        //Then
        Assert.assertEquals(2, result.size());
        Assert.assertTrue(user1fromDb.isPresent());
        Assert.assertTrue(user2fromDb.isPresent());

        //Clean
        userRepository.deleteById(id1);
        userRepository.deleteById(id2);
    }

    @Test
    public void relationshipTestBetweenUserAndCart() {
        //Given
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        cartRepository.save(cart1);
        cartRepository.save(cart2);

        User user1 = new User();
        User user2 = new User();

        user1.setCart(cart1);
        user2.setCart(cart2);
        cart1.setUser(user1);
        cart2.setUser(user2);

        userRepository.save(user1);
        userRepository.save(user2);

        //When
        User resultUser = userRepository.findByCart(cart1);

        //Then
        Assert.assertFalse(resultUser.getCart().equals(null));

        //Clean
        userRepository.deleteById(user1.getId());
        userRepository.deleteById(user2.getId());
        cartRepository.deleteAll();
    }

    @Test
    public void relationshipTestBetweenUserAndOrder() {
        //Given
        User user1 = new User();

        Order order1 = new Order();

        order1.setUser(user1);
        user1.getOrders().add(order1);

        userRepository.save(user1);
        orderRepository.save(order1);

        Order order2 = new Order();

        order2.setUser(user1);
        user1.getOrders().add(order2);

        userRepository.save(user1);
        orderRepository.save(order2);

        //When
        List<Order> userOrderListFromDb = orderRepository.findByUser(user1);
        Long firstOrderId = user1.getOrders().get(0).getId();
        Long secondOrderId = user1.getOrders().get(1).getId();

        //Then
        Assert.assertEquals(2, userOrderListFromDb.size());
        Assert.assertTrue(orderRepository.existsById(firstOrderId));
        Assert.assertTrue(orderRepository.existsById(secondOrderId));

        //Clean
        orderRepository.deleteAll();
        userRepository.deleteAll();

    }

    @Test
    public void relationshipTestBetweenUserAndInvoice() {
        //Given
        User user1 = new User();

        Invoice invoice1 = new Invoice();

        user1.getInvoices().add(invoice1);
        invoice1.setUser(user1);

        userRepository.save(user1);
        invoiceRepository.save(invoice1);

        //When
        List<Invoice> resultList = invoiceRepository.findByUser(user1);
        Long invoiceId = user1.getInvoices().get(0).getId();
        //Then
        Assert.assertEquals(1, resultList.size());
        Assert.assertTrue(invoiceRepository.existsById(invoiceId));
        //Clean
        invoiceRepository.deleteAll();
        userRepository.deleteAll();

    }
}
