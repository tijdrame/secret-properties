package com.emard.props.secretproperties;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.emard.props.secretproperties.mapper.EProduct;
import com.emard.props.secretproperties.mapper.ProductDto;
import com.emard.props.secretproperties.mapper.ProductMapper;
//import com.emard.props.secretproperties.config.NotionConfigProperties;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableConfigurationProperties(NotionConfigProperties.class)
@EnableEncryptableProperties
public class SecretPropertiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecretPropertiesApplication.class, args);
	}

	@Bean
	CommandLineRunner start(){
		return args -> {

			EProduct eProduct = new EProduct(1l, "gouro", "jokhé thiawarté", BigDecimal.valueOf(5), LocalDateTime.now(), LocalDateTime.now());
			EProduct eProduct2 = new EProduct(2l, "lait", "Lait naturel", BigDecimal.valueOf(10), LocalDateTime.now(), LocalDateTime.now());
			EProduct eProduct3 = new EProduct(3l, "Viande", "Bon pour grandir", BigDecimal.valueOf(50), LocalDateTime.now(), LocalDateTime.now());

			List<EProduct> eProducts = new ArrayList<>();
			eProducts.add(eProduct);
			eProducts.add(eProduct2);
			eProducts.add(eProduct3);

			ModelMapper mapper = new ModelMapper();
			//ProductDto dto = mapper.map(eProduct, ProductDto.class);
			TypeMap<EProduct, ProductDto> propertyMapper = mapper.createTypeMap(EProduct.class, ProductDto.class);
			//propertyMapper.addMapping(EProduct::getName, ProductDto::setNameDto);
			//ProductDto dto = mapper.map(eProduct, ProductDto.class);
			
			propertyMapper.addMappings(
      			m -> m.map(src -> src.getName(), ProductDto::setNameDto)
    		);
			ProductDto dto = mapper.map(eProduct, ProductDto.class);
			List<ProductDto> productDtos = eProducts.stream().map(e -> mapper.map(e, ProductDto.class)).collect(Collectors.toList());
			System.out.println("dto="+dto);
			System.out.println("productDtos="+productDtos);

		};
	}
}
