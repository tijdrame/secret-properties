package com.emard.props.secretproperties;

//import com.emard.props.secretproperties.config.NotionConfigProperties;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
//@EnableConfigurationProperties(NotionConfigProperties.class)
@EnableEncryptableProperties
public class SecretPropertiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecretPropertiesApplication.class, args);
	}

}
