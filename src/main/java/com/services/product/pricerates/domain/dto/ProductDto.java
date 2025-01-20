package com.services.product.pricerates.domain.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto implements Serializable {
    
    Long id;
    Long brand;
    BigDecimal price;
    Long fee;
    String currency;
    Date startDate;
    Date finishDate;
    Long priority;

}
