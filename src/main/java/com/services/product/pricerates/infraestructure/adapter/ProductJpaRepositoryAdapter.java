package com.services.product.pricerates.infraestructure.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.product.pricerates.domain.dto.ProductDto;
import com.services.product.pricerates.domain.port.out.ProductRepositoryOutPort;
import com.services.product.pricerates.infraestructure.adapter.entity.Product;
import com.services.product.pricerates.infraestructure.adapter.mapper.ProductMapper;
import com.services.product.pricerates.infraestructure.adapter.repository.ProductRepository;

import jakarta.transaction.Transactional;
import lombok.Builder;

@Service
@Transactional
@Builder
public class ProductJpaRepositoryAdapter implements ProductRepositoryOutPort {

    @Autowired
    private ProductRepository productRepository;

    private ProductMapper productMapper;

    @Override
    public Optional<List<ProductDto>> findByIdAndBrand(Long id, Long brand) {
        List<Product> products = this.productRepository.findByIdAndBrand(id, brand);

        if (products.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(products.stream().map(product -> this.productMapper.toDomainProduct(product))
            .collect(Collectors.toList()));
    }

}
