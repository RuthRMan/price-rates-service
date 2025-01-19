package com.services.product.pricerates.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.services.product.pricerates.domain.dto.ProductDto;

public interface ProductRepositoryOutPort {

   public Optional<List<ProductDto>> findByIdAndBrand(Long id, Long brand);
    
}
