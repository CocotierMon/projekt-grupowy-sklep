package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.DeliveryRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
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
public class DeliveryEntityTestSuite {
    @Autowired
    private DeliveryRepository deliveryRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Test
    public void saveAndDeleteDeliveryTest(){
        //Given
        Delivery delivery1 = new Delivery(new BigDecimal(10));
        Delivery delivery2 = new Delivery(new BigDecimal(14));
        deliveryRepository.save(delivery1);
        deliveryRepository.save(delivery2);
        //When
        List<Delivery> resultList = deliveryRepository.findAll();
        //Then
        Assert.assertEquals(2, resultList.size());
        //Given
        deliveryRepository.deleteById(delivery1.getId());
        deliveryRepository.deleteById(delivery2.getId());
        //When
        resultList = deliveryRepository.findAll();
        //Then
        Assert.assertEquals(0, resultList.size());
    }
    @Test
    public void findDeliveryTest(){
        //Given
        Delivery delivery1 = new Delivery(new BigDecimal(8));
        Delivery delivery2 = new Delivery(new BigDecimal(9.99));
        deliveryRepository.save(delivery1);
        deliveryRepository.save(delivery2);
        Long id1 = delivery1.getId();
        Long id2 = delivery2.getId();
        //When
        List<Delivery> resultList = deliveryRepository.findAll();
        Optional<Delivery> delivery1FromDb = deliveryRepository.findById(id1);
        Optional<Delivery> delivery2fromDb = deliveryRepository.findById(id2);
        //Then
        Assert.assertEquals(2, resultList.size());
        Assert.assertTrue(delivery1FromDb.isPresent());
        Assert.assertTrue(delivery2fromDb.isPresent());
        //Clean
        deliveryRepository.deleteAll();
    }
    @Test
    public void  relationshipTestBetweenDeliveryAndOrder(){
        //Given
        Order order1 = new Order();
        Order order2 = new Order();
        orderRepository.save(order1);
        orderRepository.save(order2);

        Delivery delivery1 = new Delivery(new BigDecimal(12));
        Delivery delivery2 = new Delivery(new BigDecimal(8));

        order1.setDelivery(delivery1);
        order2.setDelivery(delivery2);

        delivery1.setOrder(order1);
        delivery2.setOrder(order2);

        deliveryRepository.save(delivery1);
        deliveryRepository.save(delivery2);

        //When
        Delivery result1 = deliveryRepository.findByOrder(order1);
        Delivery result2 = deliveryRepository.findByOrder(order2);
        //Then
        Assert.assertFalse(result1.equals(null));
        Assert.assertFalse(result2.equals(null));
        Assert.assertEquals(delivery1.getId(), result1.getId());
        Assert.assertEquals(delivery2.getId(), result2.getId());

        //Clean
        deliveryRepository.deleteAll();
        orderRepository.deleteAll();
    }
}
