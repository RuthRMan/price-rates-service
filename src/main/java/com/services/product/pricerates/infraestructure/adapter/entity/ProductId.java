package com.services.product.pricerates.infraestructure.adapter.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductId implements Serializable {

    private Long id;
    private Long brand;
    private Long fee;
}
