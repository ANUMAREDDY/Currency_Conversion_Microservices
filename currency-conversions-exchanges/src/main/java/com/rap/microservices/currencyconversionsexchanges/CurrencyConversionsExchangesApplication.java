package com.rap.microservices.currencyconversionsexchanges;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurrencyConversionsExchangesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionsExchangesApplication.class, args);
	}

}
