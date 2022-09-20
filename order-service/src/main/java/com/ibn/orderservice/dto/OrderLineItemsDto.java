package com.ibn.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemsDto {

    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
