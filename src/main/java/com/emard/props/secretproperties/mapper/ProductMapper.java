package com.emard.props.secretproperties.mapper;

import java.util.List;

//import org.mapstruct.Mapper;
//import org.mapstruct.factory.Mappers;

//@Mapper
public interface ProductMapper {
    //ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    ProductDto toProductDto(EProduct product);
    List<ProductDto> toProductDtos(List<EProduct> products);
    EProduct toEProduct(ProductDto dto);
}
