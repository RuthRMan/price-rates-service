package com.services.product.pricerates.domain.port.in;

import java.util.Date;

import com.services.product.pricerates.domain.dto.ProductDto;
import com.services.product.pricerates.domain.exceptions.ProductNotFoundException;

public interface PriceRateProductInPort {
    
    public ProductDto getPriceRateProductByDateAndBrand(Date applicationDate, Long brand, Long productId) 
        throws ProductNotFoundException;

}
