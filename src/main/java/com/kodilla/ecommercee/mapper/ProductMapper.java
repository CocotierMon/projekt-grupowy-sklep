package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public Product mapToProduct(final ProductDto productDto) {
        return new Product(productDto.getId(),
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice(),
                productDto.getGroupId(),
                productDto.getOrder(),
                productDto.getCart(),
                productDto.getAmount(),
                productDto.getSum());
    }

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto(product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getGroupId(),
                product.getOrder(),
                product.getCart(),
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
                        p.getOrder(),
                        p.getCart(),
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
                        p.getOrder(),
                        p.getCart(),
                        p.getAmount(),
                        p.getSum()))
                .collect(Collectors.toList());
    }
}