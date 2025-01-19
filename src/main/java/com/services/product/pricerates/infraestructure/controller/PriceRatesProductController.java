package com.services.product.pricerates.infraestructure.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.services.product.pricerates.application.services.PriceRatesProductService;
import com.services.product.pricerates.domain.constants.PriceRateProductConstants;
import com.services.product.pricerates.domain.dto.ProductDto;
import com.services.product.pricerates.domain.exceptions.ProductNotFoundException;

@RestController
public class PriceRatesProductController {

    @Autowired
    private PriceRatesProductService priceRateProductService;
    
    @GetMapping("/product/pricerate")
    public ProductDto getPriceRateProductByDateAndBrand(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date applicationDate, 
                                    @RequestParam Long id, @RequestParam Long brand) throws ProductNotFoundException {
                return priceRateProductService.getPriceRateProductByDateAndBrand(applicationDate, brand, id);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(value=HttpStatus.CONFLICT,
                   reason=PriceRateProductConstants.PRODUCT_NOT_FOUND)
    public void handleProductNotFoundException() {
    }

}
