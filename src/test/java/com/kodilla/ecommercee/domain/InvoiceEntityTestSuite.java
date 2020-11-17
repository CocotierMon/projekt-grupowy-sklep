package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceEntityTestSuite {
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    DeliveryRepository deliveryRepository;


    @Test
    public void testInvoiceRepository() {
        User user1 = new User();
        userRepository.save(user1);
        User user2 = new User();
        userRepository.save(user2);

        Product product1 = new Product("produkt1", "opis1", new BigDecimal("11.2"), 2);
        productRepository.save(product1);
        Product product2 = new Product("produkt2", "opis2", new BigDecimal("13.2"), 3);
        productRepository.save(product2);
        Product product3 = new Product("produkt3", "opis3", new BigDecimal(1352), 10);
        productRepository.save(product3);
        Product product4 = new Product("produkt4", "opis4", new BigDecimal(112), 1);
        productRepository.save(product4);
        List<Product> products1 = new ArrayList<>();
        products1.add(product1);
        products1.add(product2);
        List<Product> products2 = new ArrayList<>();
        products2.add(product3);
        products2.add(product4);

        Cart cart1 = new Cart();
        List<Cart> carts1 = new ArrayList<>();
        cart1.setProducts(products1);
        product1.getCarts().add(cart1);
        product1.setCarts(carts1);
        product2.getCarts().add(cart1);
        product2.setCarts(carts1);
        cartRepository.save(cart1);
        Cart cart2 = new Cart();
        List<Cart> carts2 = new ArrayList<>();
        cart2.setProducts(products2);
        product3.getCarts().add(cart2);
        product3.setCarts(carts2);
        product4.getCarts().add(cart2);
        product4.setCarts(carts2);
        cartRepository.save(cart2);

        Delivery delivery1 = new Delivery(new BigDecimal(5));
        deliveryRepository.save(delivery1);
        Delivery delivery2 = new Delivery(new BigDecimal(10));
        deliveryRepository.save(delivery2);

        Order order1 = new Order(cart1, delivery1, user1);
        List<Order> orders1 = new ArrayList<>();
        orders1.add(order1);
        cart1.setOrders(orders1);
        delivery1.setOrder(order1);
        user1.setOrders(orders1);
        orderRepository.save(order1);
        Order order2 = new Order(cart2, delivery2, user2);
        List<Order> orders2 = new ArrayList<>();
        orders2.add(order2);
        cart2.setOrders(orders2);
        delivery2.setOrder(order2);
        user2.setOrders(orders2);
        orderRepository.save(order2);

        //save, findById, existsById
        Invoice invoice1 = new Invoice(user1, order1);
        List<Invoice> invoices1 = new ArrayList<>();
        user1.setInvoices(invoices1);
        order1.setInvoice(invoice1);
        invoiceRepository.save(invoice1);
        Invoice invoice2 = new Invoice(user2, order2);
        List<Invoice> invoices2 = new ArrayList<>();
        order2.setInvoice(invoice2);
        user1.setInvoices(invoices2);
        invoiceRepository.save(invoice2);

        Long id1 = invoice1.getId();
        Long id2 = invoice2.getId();
        List<Long> ids = new ArrayList<>();
        ids.add(id1);
        ids.add(id2);

        Optional<Invoice> readInvoice1 = invoiceRepository.findById(id1);
        Optional<Invoice> readInvoice2 = invoiceRepository.findById(id2);

        Assert.assertTrue(readInvoice1.isPresent());
        Assert.assertTrue(readInvoice2.isPresent());
        Assert.assertTrue(invoiceRepository.existsById(id1));
        Assert.assertTrue(invoiceRepository.existsById(id2));

        //findAll, findAllById, count,
        Assert.assertNotNull(invoiceRepository.findAll());
        Assert.assertNotNull(invoiceRepository.findAllById(ids));
        Assert.assertEquals(2, invoiceRepository.count());

        //deleteById, deleteAll
        invoiceRepository.deleteById(id1);
        Assert.assertNotEquals(2, invoiceRepository.count());
        invoiceRepository.deleteAll();
        Assert.assertFalse(invoiceRepository.existsById(id2));
    }

    @Test
    public void testCreatingCartOrderInvoice() {

        User user = new User();
        userRepository.save(user);

        Delivery delivery = new Delivery(new BigDecimal(10));
        deliveryRepository.save(delivery);

        Product product = new Product("a", "b", new BigDecimal(2), 1);
        Product product1 = new Product("c", "d", new BigDecimal(4), 1);
        productRepository.save(product);
        productRepository.save(product1);
        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product1);

        Cart cart = new Cart();
        List<Cart> carts = new ArrayList<>();
        carts.add(cart);
        product.getCarts().add(cart);
        product.setCarts(carts);
        product1.getCarts().add(cart);
        product1.setCarts(carts);
        cart.setProducts(products);
        cart.addProduct(product, 3);
        cart.addProduct(product1, 2);
        cartRepository.save(cart);

        Order order = new Order(cart, delivery, user);
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        cart.setOrders(orders);
        delivery.setOrder(order);
        user.setOrders(orders);
        orderRepository.save(order);

        Invoice invoice = new Invoice();
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoice);
        invoice.setOrder(order);
        order.setInvoice(invoice);
        invoice.setUser(user);
        user.setInvoices(invoices);
        invoiceRepository.save(invoice);

        Assert.assertEquals(new BigDecimal(10), invoice.getOrder().getDelivery().getValue());
        System.out.println("Koszt dostawy: " + invoice.getOrder().getDelivery().getValue());
        Assert.assertEquals("a", invoice.getOrder().getProducts().get(0).getName());
        Assert.assertEquals(new BigDecimal(2), invoice.getOrder().getProducts().get(0).getPrice());
        Assert.assertEquals(3, invoice.getOrder().getProducts().get(0).getAmount());
        System.out.println("Zamówione produkty: " + invoice.getOrder().getProducts().get(0).getName() +
                " cena: " + invoice.getOrder().getProducts().get(0).getPrice() +
                " ilość: " + invoice.getOrder().getProducts().get(0).getAmount());
        Assert.assertEquals("c", invoice.getOrder().getProducts().get(1).getName());
        Assert.assertEquals(new BigDecimal(4), invoice.getOrder().getProducts().get(1).getPrice());
        Assert.assertEquals(2, invoice.getOrder().getProducts().get(1).getAmount());
        System.out.println("Zamówione produkty: " + invoice.getOrder().getProducts().get(1).getName() +
                " cena: " + invoice.getOrder().getProducts().get(1).getPrice() +
                " ilość: " + invoice.getOrder().getProducts().get(1).getAmount());
        Assert.assertEquals(new BigDecimal(6), invoice.getOrder().getCart().getProducts().get(0).getSum());
        System.out.println("Całkowity koszt produktu 1: " + invoice.getOrder().getCart().getProducts().get(0).getSum());
        Assert.assertEquals(new BigDecimal(8), invoice.getOrder().getCart().getProducts().get(1).getSum());
        System.out.println("Całkowity koszt produktu 2: " + invoice.getOrder().getCart().getProducts().get(1).getSum());
        Assert.assertEquals(new BigDecimal(24), invoice.getOrder().getTotal_sum_of_order());
        System.out.println("Całkowity koszt zamówienia: " + invoice.getOrder().getTotal_sum_of_order());
        Assert.assertEquals(LocalDate.now(), invoice.getOrder().getDate_of_order());
        System.out.println("Data sprzedaży: " + invoice.getOrder().getDate_of_order());

        //CleanUp
        invoiceRepository.deleteAll();
        orderRepository.deleteAll();
        cartRepository.deleteAll();
        productRepository.deleteAll();
        deliveryRepository.deleteAll();
        userRepository.deleteAll();
    }

}
