package com.emard.props.secretproperties.mapper;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductDto {
    private String nameDto;
    private String description;
    private BigDecimal price;
}
