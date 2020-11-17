package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    OrderMapper orderMapper;
    CartMapper cartMapper;

    public Product mapToProduct(final ProductDto productDto) {
        return new Product(productDto.getId(),
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice(),
                productDto.getGroupId(),
                orderMapper.mapToOrderList(productDto.getOrders()),
                cartMapper.mapToCartList(productDto.getCarts()),
                productDto.getAmount(),
                productDto.getSum());
    }

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto(product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getGroupId(),
                orderMapper.mapToOrderDtoList(product.getOrders()),
                cartMapper.mapToCartDtoList(product.getCarts()),
                product.getAmount(),
                product.getSum());
    }

    public List<ProductDto> mapToProductDtoList(List<Product> productList) {
        return productList.stream()
                .map(p -> new ProductDto(p.getId(),
                        p.getName(),
                        p.getDescription(),
                        p.getPrice(),
                        p.getGroupId(),
                        orderMapper.mapToOrderDtoList(p.getOrders()),
                        cartMapper.mapToCartDtoList(p.getCarts()),
                        p.getAmount(),
                        p.getSum()))
                .collect(Collectors.toList());
    }

    public List<Product> mapToProductList(List<ProductDto> productList) {
        return productList.stream()
                .map(p -> new Product(p.getId(),
                        p.getName(),
                        p.getDescription(),
                        p.getPrice(),
                        p.getGroupId(),
                        orderMapper.mapToOrderList(p.getOrders()),
                        cartMapper.mapToCartList(p.getCarts()),
                        p.getAmount(),
                        p.getSum()))
                .collect(Collectors.toList());
    }
}