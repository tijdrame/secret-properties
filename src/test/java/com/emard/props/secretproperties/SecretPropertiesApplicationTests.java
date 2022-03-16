package com.emard.props.secretproperties;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class SecretPropertiesApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testPasswordEncryption() {
		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
		SimpleStringPBEConfig config = new SimpleStringPBEConfig();
		config.setPassword("samaThiabi"); // encryptor's private key
		config.setAlgorithm("PBEWithMD5AndDES");
		config.setKeyObtentionIterations("1000");
		config.setPoolSize("1");
		config.setProviderName("SunJCE");
		config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
		config.setStringOutputType("base64");
		encryptor.setConfig(config);
		String plainText = "samaDatabase";
		String encryptedPassword = encryptor.encrypt(plainText);
		System.out.println("encryptedPassword : " + encryptedPassword);
	}

}
