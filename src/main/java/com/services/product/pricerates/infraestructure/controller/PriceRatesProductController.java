package com.services.product.pricerates.infraestructure.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.services.product.pricerates.application.services.PriceRatesProductService;
import com.services.product.pricerates.domain.dto.ProductDto;

@RestController
public class PriceRatesProductController {

    @Autowired
    private PriceRatesProductService priceRateProductService;
    
    @GetMapping("/product/pricerate")
    public ProductDto getProductPriceRate(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date applicationDate, 
                                    @RequestParam Long id, @RequestParam Long brand) throws Exception {
        return priceRateProductService.getPriceRateProductByDateAndBrand(applicationDate, brand, id);
    }

}
