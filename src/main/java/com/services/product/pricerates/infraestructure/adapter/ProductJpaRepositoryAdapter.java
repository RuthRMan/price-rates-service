package com.services.product.pricerates.infraestructure.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.product.pricerates.domain.dto.ProductDto;
import com.services.product.pricerates.domain.port.ProductRepositoryPort;
import com.services.product.pricerates.infraestructure.adapter.entity.Product;
import com.services.product.pricerates.infraestructure.adapter.mapper.ProductMapper;
import com.services.product.pricerates.infraestructure.adapter.repository.ProductRepository;

import jakarta.transaction.Transactional;
import lombok.Builder;

@Service
@Transactional
@Builder
public class ProductJpaRepositoryAdapter implements ProductRepositoryPort {

    @Autowired
    private ProductRepository productRepository;

    private ProductMapper productMapper;

    @Override
    public List<ProductDto> findByIdAndBrand(Long id, Long brand) throws Exception {
        List<Product> products = this.productRepository.findByIdAndBrand(id, brand);

        if (products.isEmpty()) {
            throw new Exception();
        }

        return products.stream()
            .map(product -> this.productMapper.toDomainProduct(product))
            .collect(Collectors.toList());
    }

}
