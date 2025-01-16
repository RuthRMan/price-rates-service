package com.services.product.pricerates.application.services;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.product.pricerates.domain.dto.ProductDto;
import com.services.product.pricerates.domain.port.PriceRateProductPort;
import com.services.product.pricerates.domain.port.ProductRepositoryPort;

@Service
public class PriceRatesProductService implements PriceRateProductPort {

    @Autowired
    private ProductRepositoryPort productRepositoryPort;

    @Override
    public ProductDto getPriceRateProductByDateAndBrand(Date applicationDate, Long brand, Long productId) throws Exception {
        
        List<ProductDto> productsFromBbdd = productRepositoryPort.findByIdAndBrand(productId, brand);

        List<ProductDto> productsInDate = filterProductsByDateApplicable(productsFromBbdd, applicationDate);

        if (productsInDate.isEmpty()) {
            throw new Exception();
        }
        
        return getProductByPriority(productsInDate);
    }

    private List<ProductDto> filterProductsByDateApplicable(List<ProductDto> productsFromBbdd, Date applicationDate) {
        return productsFromBbdd.stream()
                .filter(p -> applicationDate.after(p.getStartDate()) && applicationDate.before(p.getFinishDate()))
                .collect(Collectors.toList());
    }

    private ProductDto getProductByPriority(List<ProductDto> products) {
        return products.stream().max(Comparator.comparing(ProductDto::getPriority)).get();
    }
    
}
