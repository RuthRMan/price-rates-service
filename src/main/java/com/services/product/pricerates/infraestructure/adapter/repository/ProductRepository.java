package com.services.product.pricerates.infraestructure.adapter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.services.product.pricerates.infraestructure.adapter.entity.Product;
import com.services.product.pricerates.infraestructure.adapter.entity.ProductId;

@Repository
public interface ProductRepository extends JpaRepository<Product, ProductId> {

    public List<Product> findByIdAndBrand(Long id, Long brand);
    
}
