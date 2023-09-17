package com.divakar.productcatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ProductcatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductcatalogApplication.class, args);
	}

}
