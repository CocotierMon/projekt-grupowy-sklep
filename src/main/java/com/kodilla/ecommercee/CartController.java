package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @RequestMapping(method = RequestMethod.POST , value = "createCart")
    public void createCart(){
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCart")
    public String getCart() {
        return "Cart";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateCart")
    public String updateCart(String someCart) {
        return "Update Cart";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteCart")
    public void deleteCart(Long CartID){
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUserID")
    public String getUserID(){
        return "some User";
    }

    @RequestMapping(method = RequestMethod.GET, value = "getValue")
    public Long getValue(){
        return Long.valueOf(900);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "addProduct")
    public void addProduct(){
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<String> getProducts() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "deleteProduct")
    public void deleteProduct(){
    }

    @RequestMapping(method = RequestMethod.PUT, value = "addOrder")
    public void addOrder(){
    }

    @RequestMapping(method = RequestMethod.GET, value = "getOrders")
    public List<String> getOrders() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "deleteOrder")
    public void deleteOrder(){
    }
}
