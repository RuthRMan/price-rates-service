package com.services.product.pricerates.application.services;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.product.pricerates.domain.constants.PriceRateProductConstants;
import com.services.product.pricerates.domain.dto.ProductDto;
import com.services.product.pricerates.domain.exceptions.ProductNotFoundException;
import com.services.product.pricerates.domain.port.in.PriceRateProductInPort;
import com.services.product.pricerates.domain.port.out.ProductRepositoryOutPort;

@Service
public class PriceRatesProductService implements PriceRateProductInPort {

    @Autowired
    private ProductRepositoryOutPort productRepositoryPort;

    @Override
    public ProductDto getPriceRateProductByDateAndBrand(Date applicationDate, Long brand, Long productId)
            throws ProductNotFoundException {
        Optional<List<ProductDto>> productsFromBbdd = productRepositoryPort.findByIdAndBrand(productId, brand);

        if (productsFromBbdd.isEmpty()) {
            throw new ProductNotFoundException(PriceRateProductConstants.PRODUCT_NOT_FOUND);
        }

        List<ProductDto> productsInDate = filterProductsByDateApplicable(productsFromBbdd.get(), applicationDate);

        if (productsInDate.isEmpty()) {
            throw new ProductNotFoundException(PriceRateProductConstants.PRODUCT_NOT_FOUND);
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
