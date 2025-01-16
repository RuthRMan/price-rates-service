package com.services.product.pricerates.domain.port;

import java.util.Date;

import com.services.product.pricerates.domain.dto.ProductDto;

public interface PriceRateProductPort {
    
    public ProductDto getPriceRateProductByDateAndBrand(Date applicationDate, Long brand, Long productId) throws Exception;

}
