package com.rap.microservices.currencyconversionsexchanges;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="currency-exchange-service",url="localhost:8001")
public interface CurrencyConversionProxy {

    @GetMapping(path="/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retriveExchangeValue(@PathVariable String from, @PathVariable String to );
}
