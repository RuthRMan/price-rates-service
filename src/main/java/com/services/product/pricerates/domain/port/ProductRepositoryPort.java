package com.services.product.pricerates.domain.port;

import java.util.List;

import com.services.product.pricerates.domain.dto.ProductDto;

public interface ProductRepositoryPort {

   public List<ProductDto> findByIdAndBrand(Long id, Long brand) throws Exception;
    
}
