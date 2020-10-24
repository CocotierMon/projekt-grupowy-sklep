package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<String> getProducts() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProduct")
    public String getProduct() {
        return "Some product";
    }

    @RequestMapping(method = RequestMethod.POST, value = "createProducts")
    public void createProduct(String newProduct) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateProduct")
    public String updateProduct(String someProduct) {
        return "Update Product";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void deleteProduct(Long productId){

    }
}
