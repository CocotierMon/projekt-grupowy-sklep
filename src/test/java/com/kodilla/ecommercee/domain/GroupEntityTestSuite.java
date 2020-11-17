package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupEntityTestSuite {

    @Autowired
    GroupRepository groupRepository;
    @Autowired
    ProductRepository productRepository;

    Group group1 = new Group();
    Group group2 = new Group();
    Group group3 = new Group();
    Group group4 = new Group();

    String groupName1 = "Ubrania";
    String groupName2 = "Dodatki";
    String groupName3 = "Biżuteria";
    String groupName4 = "Obuwie";

    Product kurtkaZimowa = new Product("kurtka zimowa", "Pellentesque tempus...", new BigDecimal(100), 1);
    Product plaszcz = new Product("płaszcz", "Pellentesque tempus...", new BigDecimal(150), 1);
    Product buty = new Product("buty", "Pellentesque tempus...", new BigDecimal(100), 1);
    Product rekawiczki = new Product("rękawiczki", "Pellentesque tempus...", new BigDecimal(50), 1);

    @Test
    public void testGroup() {

        //"createGroup", "getGroupsList",
        groupRepository.save(group1);
        groupRepository.save(group2);
        groupRepository.save(group3);
        groupRepository.save(group4);

        Assert.assertEquals(4, groupRepository.findAll().size());

        //"updateGroup", "deleteGroup", "getGroupByID"
        group1.setGroupName("inna nazwa");
        Long id = group1.getId();

        Optional<Group> readGroup = groupRepository.findById(id);
        Assert.assertTrue(readGroup.isPresent());

        Assert.assertEquals("inna nazwa", group1.getGroupName());

        groupRepository.deleteById(id);

        Assert.assertNotEquals(4, groupRepository.findAll().size());

        //CleanUp
        groupRepository.deleteAll();
        Assert.assertNotEquals(1, groupRepository.findAll().size());
    }

    @Test
    public void testGroupRelationsWithProduct() {

        group1.setGroupName(groupName1);
        group2.setGroupName(groupName2);
        group3.setGroupName(groupName3);
        group4.setGroupName(groupName4);

        productRepository.save(kurtkaZimowa);
        productRepository.save(plaszcz);
        productRepository.save(rekawiczki);
        productRepository.save(buty);

        List<Product> ubrania = new ArrayList<>();
        List<Product> dodatki = new ArrayList<>();
        List<Product> bizuteria = new ArrayList<>();
        List<Product> obuwie = new ArrayList<>();

        ubrania.add(kurtkaZimowa);
        ubrania.add(plaszcz);
        dodatki.add(rekawiczki);
        obuwie.add(buty);

        group1.setProductsList(ubrania);
        kurtkaZimowa.setGroupId(group1);
        plaszcz.setGroupId(group1);
        group2.setProductsList(dodatki);
        rekawiczki.setGroupId(group2);
        group4.setProductsList(obuwie);
        buty.setGroupId(group4);

        groupRepository.save(group1);
        groupRepository.save(group2);
        groupRepository.save(group3);
        groupRepository.save(group4);

        long grou1ID = group1.getId();
        Optional<Group> readGroup1 = groupRepository.findById(grou1ID);
        Assert.assertTrue(readGroup1.isPresent());

        Assert.assertEquals(2, ubrania.size());
        Assert.assertEquals(kurtkaZimowa.getGroupId().getId(), group1.getId());
        Assert.assertEquals(plaszcz.getGroupId().getId(), group1.getId());
        Assert.assertEquals(1, dodatki.size());
        Assert.assertEquals(rekawiczki.getGroupId().getId(), group2.getId());
        Assert.assertEquals(1, obuwie.size());
        Assert.assertEquals(buty.getGroupId().getId(), group4.getId());
        Assert.assertNotEquals(1, dodatki);
        Assert.assertEquals(0, bizuteria.size());

        //CleanUp
        groupRepository.deleteAll();
        Assert.assertEquals(0, groupRepository.findAll().size());
    }
}
