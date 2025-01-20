package com.services.product.pricerates.infraestructure.adapter.mapper;

import com.services.product.pricerates.domain.dto.ProductDto;
import com.services.product.pricerates.infraestructure.adapter.entity.Product;

public class ProductMapper {

    public ProductDto toDomainProduct(Product product) {
            return ProductDto.builder()
                .brand(product.getBrand())
                .currency(product.getCurrency())
                .startDate(product.getStart())
                .finishDate(product.getFinish())
                .id(product.getId())
                .price(product.getPrice())
                .fee(product.getFee())
                .priority(product.getPriority())
            .build();
    }

}
