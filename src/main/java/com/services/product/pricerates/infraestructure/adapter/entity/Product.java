package com.services.product.pricerates.infraestructure.adapter.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Getter;

@Entity
@Getter
@IdClass(ProductId.class)
public class Product {

    @Id
    Long id;
    @Id
    Long brand;
    @Id
    Long fee;    

    Date start;
    Date finish;    
    Long priority;
    BigDecimal price;
    String currency;
    
}
