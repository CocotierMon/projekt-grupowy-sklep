package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductEntityTestSuite {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private GroupRepository groupRepository;

    private static final String GROUPNAME = "TEST GROUP";

    @Test
    public void testProductSave() {
        //given
        Product product = new Product("kubek", "zwykły kubek", new BigDecimal(30), 3);
        Product product1 = new Product("myszka", "zwykła myszka", new BigDecimal(50), 10);
        //when
        productRepository.save(product);
        productRepository.save(product1);
        //then
        Assert.assertEquals(2, productRepository.count());
        //clean
        productRepository.deleteAll();
    }

    @Test
    public void testProductAddToGroup() {
        //given
        Group group = new Group(GROUPNAME);
        Product product = new Product("kubek", "zwykły kubek", new BigDecimal(30), 3);
        Product product1 = new Product("myszka", "zwykła myszka", new BigDecimal(50), 10);
        //when
        group.getProductsList().add(product);
        product.setGroupId(group);
        group.getProductsList().add(product1);
        product1.setGroupId(group);
        groupRepository.save(group);
        //then
        Assert.assertEquals(2, group.getProductsList().size());
        Assert.assertEquals(GROUPNAME,product.getGroupId().getGroupName());
        Assert.assertEquals(GROUPNAME,product1.getGroupId().getGroupName());

        //clean
        groupRepository.deleteAll();
    }

    @Test
    public void testProductAddToCart() {
        //given
        Cart cart = new Cart();
        Product product = new Product("kubek", "zwykły kubek", new BigDecimal(30), 3);
        Product product1 = new Product("myszka", "zwykła myszka", new BigDecimal(50), 10);
        //when
        cart.addProduct(product, 1);
        cart.addProduct(product1, 2);

        productRepository.save(product);
        productRepository.save(product1);
        cartRepository.save(cart);
        //then
        Assert.assertEquals(3, cart.getProducts().size());
        Assert.assertFalse(cartRepository.findAll().isEmpty());
        //clean
        cartRepository.deleteAll();
        productRepository.deleteAll();
    }
}
